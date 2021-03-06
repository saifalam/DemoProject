package com.demo.project.mvc.controller.registratrion;

import com.demo.project.mvc.model.viewmodel.UserRegistrationViewModel;
import com.demo.project.mvc.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

/**
 * Created by saif on 3/27/15.
 */
@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    UserRegistrationService registrationService;

    @RequestMapping( value = "registration",method = RequestMethod.GET)
    public String getRegistration(Model model) {
        UserRegistrationViewModel viewModel= new UserRegistrationViewModel();
        model.addAttribute("viewModel", viewModel);
        return "registrationForm";
    }

    @RequestMapping( value = "registration", method = RequestMethod.POST)
    public String makeRegistration(Model model, @ModelAttribute("viewModel")@Valid UserRegistrationViewModel viewModel, BindingResult result) {
       if(result == null || result.hasErrors()){
           model.addAttribute("viewModel", viewModel);
           return "registrationForm";
       }

        if(viewModel!= null){
            registrationService.doRegistration(viewModel);
            model.addAttribute("viewModel", viewModel);
            return "registrationSuccess";
        }
        model.addAttribute("viewModel", viewModel);
        return "registrationForm";
    }

}
