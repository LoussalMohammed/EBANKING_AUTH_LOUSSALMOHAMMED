package org.roleApp.rollApp.balance.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.balance.dto.request.CreateBalanceDTO;
import org.roleApp.rollApp.balance.dto.request.UpdateBalanceDTO;
import org.roleApp.rollApp.balance.dto.response.ResponseBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.balance.service.BalanceService;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/balance")
@Slf4j
@RequiredArgsConstructor
public class BalanceController extends BaseController<Balance, Long, CreateBalanceDTO, UpdateBalanceDTO, ResponseBalanceDTO> {
    private final BalanceService balanceService;

    @Override
    protected BaseService<Long, CreateBalanceDTO, UpdateBalanceDTO, ResponseBalanceDTO> getService() {
        return balanceService;
    }

    @Override
    public Class<Balance> getEntityClass() {
        return Balance.class;
    }
}
