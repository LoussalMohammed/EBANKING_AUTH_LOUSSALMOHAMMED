package org.roleApp.rollApp.account.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.account.dto.request.UpdateAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.common.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface UpdateAccountMapper extends BaseMapper<Account, UpdateAccountDTO> {
}
