package org.roleApp.rollApp.contact.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_user.dto.response.EmbeddableAppUserDTO;
import org.springframework.lang.NonNull;

public record ResponseContactDTO(

        @NonNull
        Long id,

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        String address,

        @NotNull
        EmbeddableAppUserDTO user
) {
}
