package org.roleApp.rollApp.balance.service;

import org.roleApp.rollApp.balance.dto.request.CreateBalanceDTO;
import org.roleApp.rollApp.balance.dto.request.UpdateBalanceDTO;
import org.roleApp.rollApp.balance.dto.response.ResponseBalanceDTO;
import org.roleApp.rollApp.common.service.BaseService;

public interface BalanceService extends BaseService<Long, CreateBalanceDTO, UpdateBalanceDTO, ResponseBalanceDTO> {
}
