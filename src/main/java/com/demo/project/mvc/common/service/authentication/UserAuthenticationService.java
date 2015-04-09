package com.demo.project.mvc.common.service.authentication;

import com.demo.project.mvc.model.datamodel.LoginUser;
import com.demo.project.mvc.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


/**
 * Created by saif on 3/20/15.
 */

@Service
@Transactional
public class UserAuthenticationService {


    @Autowired
    UserRegistrationRepository userRegistrationRepository;


    public LoginUser getLoginUserByName(String username) {
        return userRegistrationRepository.getLoginUserByName(username);
    }
}
