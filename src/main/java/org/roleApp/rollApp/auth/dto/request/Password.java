package org.roleApp.rollApp.auth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record Password(
        @NotBlank
        String password
)
{}
