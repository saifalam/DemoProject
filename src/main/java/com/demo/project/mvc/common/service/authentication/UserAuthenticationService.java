package com.demo.project.mvc.common.service.authentication;

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

    private String ROLE_USER = "ROLE_USER";
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getName()!=null && authentication.getCredentials()!=null){
            String username= authentication.getName();
            String password= authentication.getCredentials().toString();




        }

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
