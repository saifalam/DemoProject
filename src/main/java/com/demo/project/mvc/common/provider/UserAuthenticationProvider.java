package com.demo.project.mvc.common.provider;

import com.demo.project.mvc.common.encryptor.RandomEncryptor;
import com.demo.project.mvc.common.enums.ResponseCode;
import com.demo.project.mvc.common.service.authentication.TokenService;
import com.demo.project.mvc.common.service.authentication.UserAuthenticationService;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.model.datamodel.TokenDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saif on 4/8/15.
 */
public class UserAuthenticationProvider  implements AuthenticationProvider {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    TokenService tokenService;

    @Autowired
    RandomEncryptor randomEncryptor;

    private String ROLE_USER = "ROLE_USER";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getName()!=null && authentication.getCredentials()!=null){
            WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
            TokenDataModel userToken = tokenService.getUserToken(authentication.getName(), authentication.getCredentials().toString(), authenticationDetails.getRemoteAddress());

            try{
//                String username= authentication.getName();
//                String password= authentication.getCredentials().toString();
//                // double  userId= authenticationRepository.getAllByUserName(username);
//                LoginUser loginUser =userAuthenticationService.getLoginUserByName(username);
                List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

                if(userToken != null && userToken.getResponseCode()== ResponseCode.OPERATION_SUCCESSFUL.getCode()){
                    AUTHORITIES.add(new SimpleGrantedAuthority(ROLE_USER));
                    return new UsernamePasswordAuthenticationToken(userToken,"",AUTHORITIES);
                }
                else if(userToken != null && userToken.getResponseCode()== ResponseCode.SECURITY_ERROR.getCode()){
                    throw new AuthException("Please check username or password !!!!.");
                }
                else if(userToken != null && userToken.getResponseCode()== ResponseCode.INVALID_ARGUMENT.getCode()){
                    throw new AuthException("Invalid username or password !!!!.");
                }
                else if(userToken != null && userToken.getResponseCode()== ResponseCode.AUTHENTICATION_FAILED.getCode()){
                    throw new AuthException("Authentication failed !!!!.");
                }
                else{
                    throw new AuthException("Runtime Error !!!!.");
                }
            }catch(Exception ex){
                throw new AuthException(ex.getMessage());
            }
        }
        else{
            throw new AuthException(" please enter Login username and password !!!.");
        }
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }
}
class AuthException extends AccountStatusException {
    public AuthException(String msg) {
        super(msg);
    }
}

