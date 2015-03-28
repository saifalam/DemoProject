package com.demo.project.mvc.service;

import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import com.demo.project.mvc.model.viewmodel.UserRegistrationViewModel;
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

    public void createRegisterUser(UserRegistrationEntityModel model){
        userRegistrationRepository.create(model);
    }

    public void updateRegisterUser(UserRegistrationEntityModel model){
        userRegistrationRepository.update(model);
    }

    public void deleteRegisterUser(UserRegistrationEntityModel model){
        userRegistrationRepository.delete(model);
    }

    public UserRegistrationEntityModel getUserRegistrationEntityModelFromViewModel(UserRegistrationViewModel viewModel) {
        UserRegistrationEntityModel registrationEntityModel= new UserRegistrationEntityModel();
        registrationEntityModel.setFullName(viewModel.getFullName());
        registrationEntityModel.setUserName(viewModel.getUserName());
        registrationEntityModel.setEmail(viewModel.getEmail());
        registrationEntityModel.setDateOfBirth(viewModel.getDateOfBirth());
        registrationEntityModel.setGender(viewModel.getGender().toString());
        return  registrationEntityModel;
    }
}
