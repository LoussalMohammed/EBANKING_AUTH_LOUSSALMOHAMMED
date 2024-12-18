package org.roleApp.rollApp.card.dto.request;


public record UpdateCardDTO(
        String cardNumber,

        String cardType,

        Long userId
) {
}
