package org.roleApp.rollApp.contact.dto.request;

import jakarta.validation.constraints.Email;

public record UpdateContactDTO(
        String name,

        @Email
        String email,

        String phone,

        String address,

        Long userId
) {
}
