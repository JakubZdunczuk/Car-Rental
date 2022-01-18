package pl.coderslab.carrental.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordEqual {

    String message() default "default message from custom validator";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

