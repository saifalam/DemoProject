package com.demo.project.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by saif on 3/20/15.
 */
public class MyPhoneValidator implements ConstraintValidator<Phone,String> {

    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String mobileNo, ConstraintValidatorContext cVCxt) {

        if(mobileNo== null || mobileNo.isEmpty()){
            return false;
        }

        if (mobileNo.matches("\\d{11}")){
            return true;
        }
        else
        return false;
    }
}
