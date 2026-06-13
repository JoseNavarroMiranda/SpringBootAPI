package com.example.SpringBootAPI.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordUpdateRequest {
    @NotNull
    private String Password;
    @NotNull
    private String NewPassword;
}
