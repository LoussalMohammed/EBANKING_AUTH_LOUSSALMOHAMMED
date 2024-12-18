package org.roleApp.rollApp.balance.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.balance.dto.response.ResponseBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface ResponseBalanceMapper extends BaseMapper<Balance, ResponseBalanceDTO> {
}
