package org.roleApp.rollApp.balance.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.balance.dto.request.CreateBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateBalanceMapper extends BaseMapper<Balance, CreateBalanceDTO> {
}
