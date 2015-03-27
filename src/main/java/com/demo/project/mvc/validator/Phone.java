package com.demo.project.mvc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by saif on 3/20/15.
 */

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = MyPhoneValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

   String message() default"Required 11 digits";

//    String message() default "{Phone}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
