package org.roleApp.rollApp.balance.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.balance.dto.response.EmbeddableBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface EmbeddableBalanceMapper extends BaseMapper<Balance, EmbeddableBalanceDTO> {
}
