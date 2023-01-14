package ru.platform.demo.annotations;

import ru.platform.demo.validations.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface ValidName {
    String message() default "Строка должна состоять только из букв (кириллица)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}