package org.roleApp.rollApp.balance.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.balance.dto.request.UpdateBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface UpdateBalanceMapper extends BaseMapper<Balance, UpdateBalanceDTO> {
}
