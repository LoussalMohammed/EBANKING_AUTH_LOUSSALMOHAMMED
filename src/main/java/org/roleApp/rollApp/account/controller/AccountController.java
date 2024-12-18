package org.roleApp.rollApp.account.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.roleApp.rollApp.account.dto.request.CreateAccountDTO;
import org.roleApp.rollApp.account.dto.request.UpdateAccountDTO;
import org.roleApp.rollApp.account.dto.response.ResponseAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.account.service.AccountService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/account")
@RequiredArgsConstructor
public class AccountController extends BaseController<Account, Long, CreateAccountDTO, UpdateAccountDTO, ResponseAccountDTO> {
    private final AccountService accountService;

    @Override
    protected BaseService<Long, CreateAccountDTO, UpdateAccountDTO, ResponseAccountDTO> getService() {
        return accountService;
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }


}
