package com.demo.project.mvc.service;

import com.demo.project.mvc.common.encryptor.RandomEncryptor;
import com.demo.project.mvc.common.passwordGenerator.RandomPasswordGenerator;
import com.demo.project.mvc.common.repository.authentication.AuthenticationRepository;
import com.demo.project.mvc.model.entitymodel.AuthenticationEntityModel;
import com.demo.project.mvc.model.entitymodel.UserRegistrationEntityModel;
import com.demo.project.mvc.model.viewmodel.UserRegistrationViewModel;
import com.demo.project.mvc.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by saif on 3/20/15.
 */
@Service
@Transactional
public class UserRegistrationService {

    @Value("${password.minlength}")
    private int passwordMinLength;

    @Value("${password.maxlength}")
    private int passwordMaxLength;

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    RandomEncryptor randomEncryptor;

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
        registrationEntityModel.setMobileNo(viewModel.getMobileNo());
        return  registrationEntityModel;
    }

    public void doRegistration(UserRegistrationViewModel viewModel) {
        UserRegistrationEntityModel registrationEntityModel= this.getUserRegistrationEntityModelFromViewModel(viewModel);
        this.createRegisterUser(registrationEntityModel);
        this.assignPassword(viewModel);
//        email sending code:  to do later
    }

    private void assignPassword(UserRegistrationViewModel viewModel) {

        int userId= this.getUserIdByUserName(viewModel.getUserName());
//        int minLen = passwordMinLength;
//        int maxLen = passwordMaxLength;
//        String generatedLoginPassword = RandomPasswordGenerator.generatePassword(minLen, maxLen);
        String generatedLoginPassword="123456Ss";
        String loginPassword= randomEncryptor.encrypt(generatedLoginPassword);
        AuthenticationEntityModel authenticationEntityModel= this.getAuthEntityModelFromIdAndPassword(userId, loginPassword);
        this.createAuthentication(authenticationEntityModel);
    }

    private void createAuthentication(AuthenticationEntityModel authenticationEntityModel) {
        authenticationRepository.create(authenticationEntityModel);
    }

    private AuthenticationEntityModel getAuthEntityModelFromIdAndPassword(long userId, String loginPassword) {

        AuthenticationEntityModel entityModel= new AuthenticationEntityModel();
        entityModel.setUserId((int)userId);
        entityModel.setUserPassword(loginPassword);
        entityModel.setIsActive(1);
        return entityModel;
    }

    private int getUserIdByUserName(String userName) {
        return userRegistrationRepository.getUserIdByUserName( userName);
    }

}
