package org.roleApp.rollApp.card.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.card.dto.request.CreateCardDTO;
import org.roleApp.rollApp.card.dto.request.UpdateCardDTO;
import org.roleApp.rollApp.card.dto.response.ResponseCardDTO;
import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.card.service.CardService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/card")
@Slf4j
@RequiredArgsConstructor
public class CardController extends BaseController<Card, Long, CreateCardDTO, UpdateCardDTO, ResponseCardDTO> {
    private final CardService cardService;

    @Override
    protected BaseService<Long, CreateCardDTO, UpdateCardDTO, ResponseCardDTO> getService() {
        return cardService;
    }

    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }
}
