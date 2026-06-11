package com.example.SpringBootAPI.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final int MIN_LENGTH = 16;
    private static final String SPECIAL_CHARS = "!@#$%^&*";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){

        if (password == null){
            return false;
        }
        if (password.length() < MIN_LENGTH){
            return false;
        }
        boolean hasNumber = password.matches(".*[0-9].*");

        boolean hasSpecialChar = password.chars()
                .anyMatch(c -> SPECIAL_CHARS.indexOf(c) >= 0);

        return hasNumber && hasSpecialChar;
    }
}
