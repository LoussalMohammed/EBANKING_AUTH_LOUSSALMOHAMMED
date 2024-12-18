package org.roleApp.rollApp.account.dto.request;


public record UpdateAccountDTO(
        String accountNumber,

        String accountType,

        Long balanceId,

        Long userId
) {
}
