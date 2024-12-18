package org.roleApp.rollApp.balance.dto.response;

import jakarta.validation.constraints.NotNull;

public record EmbeddableBalanceDTO(
        @NotNull
        Long id,

        @NotNull
        Double amount
) {
}
