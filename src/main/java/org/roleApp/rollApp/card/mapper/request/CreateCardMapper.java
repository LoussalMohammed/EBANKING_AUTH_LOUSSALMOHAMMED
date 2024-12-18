package org.roleApp.rollApp.card.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.card.dto.request.CreateCardDTO;
import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateCardMapper extends BaseMapper<Card, CreateCardDTO> {
}
