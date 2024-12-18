package org.roleApp.rollApp.balance.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateBalanceDTO(
        @NotNull
        Double amount,

        @NotNull
        Long accountId
) {
}

