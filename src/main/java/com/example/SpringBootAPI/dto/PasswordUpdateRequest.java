package com.example.SpringBootAPI.dto;

import com.example.SpringBootAPI.validations.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordUpdateRequest {

    @NotBlank
    private String password;

    @NotBlank
    @ValidPassword
    private String newPassword;
}
