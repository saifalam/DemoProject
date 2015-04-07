package com.demo.project.mvc.common.service.authentication;

import com.demo.project.mvc.common.repository.authentication.AuthenticationRepository;
import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


/**
 * Created by saif on 3/20/15.
 */
public class UserAuthenticationService implements AuthenticationProvider  {

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    UserRegistrationRepository userRegistrationRepository;
    private String ROLE_USER = "ROLE_USER";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getName()!=null && authentication.getCredentials()!=null){
            try{
                  String username= authentication.getName();
                  String password= authentication.getCredentials().toString();
                 // double  userId= authenticationRepository.getAllByUserName(username);
                  LoginUser loginUser =userRegistrationRepository.getLoginUserByName(username);

                if(loginUser != null && loginUser.getPassword()!=null && !loginUser.getPassword().isEmpty()){

                    if(loginUser.getPassword().equals(password)){
                        return new UsernamePasswordAuthenticationToken(loginUser,ROLE_USER);
                    }
                    else{
                        throw  new AuthException("Login username or password is not correct !!!.");
                    }
                }
                else{
                    throw new AuthException("Invalid username or password !!!!.");
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
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
 class AuthException extends AccountStatusException{
     public AuthException(String msg){
         super(msg);
     }
}