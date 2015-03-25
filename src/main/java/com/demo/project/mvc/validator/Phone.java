package com.demo.project.mvc.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by saif on 3/20/15.
 */

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = MyPhoneValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default"{Phone}";
}
