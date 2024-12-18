package org.roleApp.rollApp.balance.dto.request;

public record UpdateBalanceDTO(
        Double amount,

        Long accountId
) {
}
