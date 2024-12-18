package org.roleApp.rollApp.account.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.account.dto.response.ResponseAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface ResponseAccountMapper extends BaseMapper<Account, ResponseAccountDTO> {
}
