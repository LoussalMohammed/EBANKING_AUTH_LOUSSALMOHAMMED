package org.roleApp.rollApp.loan.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.roleApp.rollApp.app_user.dto.response.EmbeddableAppUserDTO;

public record ResponseLoanDTO(
        @NotNull
        Long id,

        @NotBlank(message = "Loan amount is required")
        Double amount,

        @NotBlank(message = "Interest rate is required")
        Double interestRate,

        @NotBlank(message = "Loan term is required")
        Integer term,

        @NotNull
        EmbeddableAppUserDTO user
) {
}
