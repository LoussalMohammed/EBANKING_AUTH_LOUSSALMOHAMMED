package org.roleApp.rollApp.loan.dto.request;


public record UpdateLoanDTO(

        Double amount,

        Double interestRate,

        Integer term,

        Long userId
) {
}
