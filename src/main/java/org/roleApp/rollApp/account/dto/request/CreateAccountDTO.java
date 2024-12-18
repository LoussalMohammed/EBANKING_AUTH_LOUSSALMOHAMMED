package org.roleApp.rollApp.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAccountDTO(
        @NotBlank(message = "Account number is required")
        String accountNumber,

        @NotBlank(message = "Account type is required")
        String accountType,

        @NotNull
        Long userId
)
{}
