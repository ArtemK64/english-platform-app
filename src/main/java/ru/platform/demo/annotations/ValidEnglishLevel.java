package ru.platform.demo.annotations;


import ru.platform.demo.validations.EnglishLevelValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnglishLevelValidator.class)
@Documented
public @interface ValidEnglishLevel {
    String message() default "Введите корректный уровень знания языка";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}