package org.roleApp.rollApp.card.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmbeddableCardDTO(
        @NotNull
        Long id,

        @NotBlank(message = "Card number is required")
        String cardNumber,

        @NotBlank(message = "Card type is required")
        String cardType
) {
}
