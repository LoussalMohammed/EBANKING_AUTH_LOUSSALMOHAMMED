package org.roleApp.rollApp.card.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCardDTO(
        @NotBlank(message = "Card number is required")
        String cardNumber,

        @NotBlank(message = "Card type is required")
        String cardType,

        @NotNull
        Long userId
) {
}
