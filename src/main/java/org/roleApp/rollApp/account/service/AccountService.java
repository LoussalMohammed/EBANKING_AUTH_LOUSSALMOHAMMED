package org.roleApp.rollApp.account.service;

import org.roleApp.rollApp.account.dto.request.CreateAccountDTO;
import org.roleApp.rollApp.account.dto.request.UpdateAccountDTO;
import org.roleApp.rollApp.account.dto.response.ResponseAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.common.service.BaseService;

import java.util.List;

public interface AccountService extends BaseService<Long, CreateAccountDTO, UpdateAccountDTO, ResponseAccountDTO> {

}
