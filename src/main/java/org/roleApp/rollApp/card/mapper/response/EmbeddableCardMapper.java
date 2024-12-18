package org.roleApp.rollApp.card.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.card.dto.response.EmbeddableCardDTO;
import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface EmbeddableCardMapper extends BaseMapper<Card, EmbeddableCardDTO> {
}
