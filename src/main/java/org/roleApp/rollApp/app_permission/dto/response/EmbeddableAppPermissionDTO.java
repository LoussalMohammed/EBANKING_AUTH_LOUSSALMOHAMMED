package org.roleApp.rollApp.app_permission.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmbeddableAppPermissionDTO(
        @NotNull
        Long id,
        @NotBlank(message = "role should have a name")
        String name
) {
}
