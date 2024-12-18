package org.roleApp.rollApp.card.service;


import org.roleApp.rollApp.card.dto.request.CreateCardDTO;
import org.roleApp.rollApp.card.dto.request.UpdateCardDTO;
import org.roleApp.rollApp.card.dto.response.ResponseCardDTO;
import org.roleApp.rollApp.common.service.BaseService;

public interface CardService extends BaseService<Long, CreateCardDTO, UpdateCardDTO, ResponseCardDTO> {
}
