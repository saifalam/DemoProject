package com.demo.project.mvc.common.service.authentication;

import com.demo.project.mvc.common.repository.authentication.AuthenticationRepository;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by saif on 3/20/15.
 */
@Service
@Transactional
public class UserAuthenticationService implements AuthenticationProvider {

    @Autowired
    AuthenticationRepository authenticationRepository;
    private String ROLE_USER = "ROLE_USER";
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getName()!=null && authentication.getCredentials()!=null){
            String username= authentication.getName();
            String password= authentication.getCredentials().toString();
           // double  userId= authenticationRepository.getAllByUserName(username);
            UserRegistrationEntityModel registrationEntityModel=authenticationRepository.getAllByUserName(username);

            if(registrationEntityModel != null && registrationEntityModel.getId()!= 0){

            }




        }

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
