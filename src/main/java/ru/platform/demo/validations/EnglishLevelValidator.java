package ru.platform.demo.validations;

import ru.platform.demo.annotations.ValidEnglishLevel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EnglishLevelValidator implements ConstraintValidator<ValidEnglishLevel, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> listOfEnglishLevels =
                List.of("A1", "A2", "B1", "B2", "C1", "C2", "А1", "А2", "В1", "В2", "С1", "С2");
        for (String englishLevel: listOfEnglishLevels) {
            if (englishLevel.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
