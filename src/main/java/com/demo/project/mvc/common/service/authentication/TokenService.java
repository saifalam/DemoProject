package com.demo.project.mvc.common.service.authentication;

import com.demo.project.mvc.common.encryptor.RandomEncryptor;
import com.demo.project.mvc.common.enums.ResponseCode;
import com.demo.project.mvc.common.enums.UserStatus;
import com.demo.project.mvc.common.repository.authentication.TokenRepository;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.datamodel.TokenDataModel;
import com.demo.project.mvc.model.entitymodel.Token;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import com.demo.project.mvc.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * Created by saif on 4/13/15.
 */
@Service
@Transactional
public class TokenService {

    private static final long ONE_MINUTE_IN_MILLIS = 60000;

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    RandomEncryptor randomEncryptor;

    @Value("${token.life.time.in.min}")
    private int tokenLifeTimeInMinutes;

    @Value("${token.update.interval.in.min}")
    private String tokenUpdateIntervalInMinutes;


    public TokenDataModel getUserToken(String username, String password, String remoteAddress) {

        TokenDataModel tokenDataModel =new TokenDataModel();

        UserRegistrationEntityModel registrationEntityModel=userRegistrationRepository.getAllByUserName(username);

        if(registrationEntityModel ==null){
            tokenDataModel.setResponseCode(ResponseCode.AUTHENTICATION_FAILED.getCode());
            tokenDataModel.getErrors().add("Authentication failed");
            return tokenDataModel;
        }
        LoginUser loginUser =userAuthenticationService.getLoginUserByName(registrationEntityModel.getUserName());
        if(loginUser != null && loginUser.getPassword()!=null && !loginUser.getPassword().isEmpty()){

            loginUser.setPassword(randomEncryptor.decrypt(loginUser.getPassword()));
            if(loginUser.getPassword().equals(password)){
                tokenDataModel= this.getToken(remoteAddress, registrationEntityModel);
            }
            else{
                tokenDataModel.setResponseCode(ResponseCode.SECURITY_ERROR.getCode());
                tokenDataModel.getErrors().add("Please check username or password");
            }
        }else{
            tokenDataModel.setResponseCode(ResponseCode.INVALID_ARGUMENT.getCode());
            tokenDataModel.getErrors().add("Invalid argument");
        }


        return tokenDataModel;
    }

    private TokenDataModel getToken(String remoteAddress, UserRegistrationEntityModel registrationEntityModel) {

        tokenRepository.DeleteTokenByUserID(registrationEntityModel.getId());
        TokenDataModel tokenDataModel= new TokenDataModel();
        String tokenString="";
        if(!remoteAddress.equals("") && !remoteAddress.isEmpty()){
            tokenString= UUID.randomUUID().toString();
            Date currentTime = new Date();
            Date expireTime = new Date();
            expireTime.setTime(currentTime.getTime() + (tokenLifeTimeInMinutes* ONE_MINUTE_IN_MILLIS));
            tokenDataModel.setToken(tokenString);
            tokenDataModel.setUserName(registrationEntityModel.getUserName());
            tokenDataModel.setUserId(registrationEntityModel.getId());
            tokenDataModel.setUserStatus(UserStatus.ACTIVE.getCode());
            tokenDataModel.setRemoteIp(remoteAddress);
            tokenDataModel.setResponseCode(ResponseCode.OPERATION_SUCCESSFUL.getCode());
            tokenDataModel.setLoginMessage("Login Successful");
            Token token= this.getTokenEntityFromTokenDataModel(tokenDataModel,currentTime,expireTime);
            tokenRepository.create(token);

        }else{
            tokenDataModel.setResponseCode(ResponseCode.REMOTE_ERROR.getCode());
            tokenDataModel.setLoginMessage("Login Failed.. ");
        }
        return tokenDataModel;
    }

    private Token getTokenEntityFromTokenDataModel(TokenDataModel tokenDataModel, Date currentTime, Date expireTime) {

        Token token= new Token();
        token.setId(tokenDataModel.getToken());
        token.setCreateOn(currentTime);
        token.setExpiredOn(expireTime);
        token.setUserId(tokenDataModel.getUserId());
        token.setRequestedIP(tokenDataModel.getRemoteIp());
        return token;
    }


    public void deleteUserToken(String token) {
         tokenRepository.deleteUserToken(token);
    }

    public Token updateTokenExpireTime(Token token) {
        long lastUpdateTime = (token.getExpiredOn().getTime() - (tokenLifeTimeInMinutes * ONE_MINUTE_IN_MILLIS));
        long currentTime = new Date().getTime();

        long tokenUpdateIntervalInMinutesLong = Long.parseLong(tokenUpdateIntervalInMinutes);

        if ((currentTime - lastUpdateTime) >= (tokenUpdateIntervalInMinutesLong * ONE_MINUTE_IN_MILLIS)) {
            long newExpireTime = new Date().getTime() + (tokenLifeTimeInMinutes * ONE_MINUTE_IN_MILLIS);
            token.setExpiredOn(new Date(newExpireTime));

            tokenRepository.update(token);
        }
        return token;
    }
}
