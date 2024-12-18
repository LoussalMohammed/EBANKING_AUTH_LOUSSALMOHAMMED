package org.roleApp.rollApp.account.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.account.dto.request.CreateAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreateAccountMapper extends BaseMapper<Account, CreateAccountDTO> {
}
