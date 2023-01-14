package ru.platform.demo.validations;

import ru.platform.demo.annotations.ValidName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = Pattern.compile("[а-яА-Я]+").matcher(s);
        return matcher.matches();
    }
}