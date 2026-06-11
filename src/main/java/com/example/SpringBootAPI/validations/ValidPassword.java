package com.example.SpringBootAPI.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)

public @interface ValidPassword {
    String message() default "La contraseña debe de terner minimo 16 caracteres, al menos un numero y un simbolo especial";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
