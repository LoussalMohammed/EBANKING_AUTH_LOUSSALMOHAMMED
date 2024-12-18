package org.roleApp.rollApp.loan.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateLoanDTO(

        @NotBlank(message = "Loan amount is required")
        Double amount,

        @NotBlank(message = "Interest rate is required")
        Double interestRate,

        @NotBlank(message = "Loan term is required")
        Integer term,

        @NotNull
        Long userId
)
{}
