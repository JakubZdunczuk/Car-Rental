package pl.coderslab.carrental.validator;

import pl.coderslab.carrental.user.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, User> {

    @Override
    public void initialize(PasswordEqual arg0) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext arg1) {
        return user.getPassword().equals(user.getPasswordConfirm());
    }
}