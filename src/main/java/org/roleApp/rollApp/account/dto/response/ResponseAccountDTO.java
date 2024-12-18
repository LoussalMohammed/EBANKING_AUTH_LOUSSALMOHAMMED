package org.roleApp.rollApp.account.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_user.dto.response.EmbeddableAppUserDTO;
import org.roleApp.rollApp.balance.dto.response.EmbeddableBalanceDTO;

public record ResponseAccountDTO(

        @NotNull
        Long id,
        @NotBlank(message = "Account number is required")
        String accountNumber,

        @NotBlank(message = "Account type is required")
        String accountType,

        @NotNull
        EmbeddableBalanceDTO balance,

        @NotNull
        EmbeddableAppUserDTO user
) {
}
