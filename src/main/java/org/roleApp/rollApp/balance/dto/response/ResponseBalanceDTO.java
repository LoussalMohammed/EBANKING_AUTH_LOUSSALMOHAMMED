package org.roleApp.rollApp.balance.dto.response;

import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.account.dto.response.EmbeddableAccountDTO;

public record ResponseBalanceDTO(
        @NotNull
        Long id,

        @NotNull
        Double amount,

        @NotNull
        EmbeddableAccountDTO account
) {
}
