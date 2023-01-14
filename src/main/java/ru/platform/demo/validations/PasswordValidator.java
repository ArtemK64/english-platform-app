package ru.platform.demo.validations;

import ru.platform.demo.annotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = Pattern.compile(".{8,20}").matcher(s);
        return matcher.matches();
    }
}