package com.demo.project.mvc.service;

import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import com.demo.project.mvc.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by saif on 3/20/15.
 */
@Service
@Transactional
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    public void createRegistarUser(UserRegistrationEntityModel model){
        userRegistrationRepository.create(model);
    }

    public void updateRegistarUser(UserRegistrationEntityModel model){
        userRegistrationRepository.update(model);
    }

    public void deleteRegistarUser(UserRegistrationEntityModel model){
        userRegistrationRepository.delete(model);
    }
}
