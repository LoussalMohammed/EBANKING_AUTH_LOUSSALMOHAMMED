package org.roleApp.rollApp.balance.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.account.mapper.request.UpdateAccountMapper;
import org.roleApp.rollApp.account.repository.AccountRepository;
import org.roleApp.rollApp.balance.dto.request.CreateBalanceDTO;
import org.roleApp.rollApp.balance.dto.request.UpdateBalanceDTO;
import org.roleApp.rollApp.balance.dto.response.ResponseBalanceDTO;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.balance.mapper.request.CreateBalanceMapper;
import org.roleApp.rollApp.balance.mapper.response.ResponseBalanceMapper;
import org.roleApp.rollApp.balance.repository.BalanceRepository;
import org.roleApp.rollApp.balance.service.BalanceService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final CreateBalanceMapper createBalanceMapper;
    private final UpdateAccountMapper updateAccountMapper;
    private final ResponseBalanceMapper responseBalanceMapper;
    private final BalanceRepository balanceRepository;
    private final AccountRepository accountRepository;

    @Override
    public ResponseBalanceDTO create(CreateBalanceDTO requestDTO) {
        Account account = accountRepository.findByIdOrElseThrow(requestDTO.accountId());
        Balance balance = createBalanceMapper.toE(requestDTO);

        account.setBalance(balance);
        balance.setAccount(account);

        balanceRepository.save(balance);
        return responseBalanceMapper.toOT(balance);
    }

    @Override
    public PageResponse<ResponseBalanceDTO> findAll(Pageable pageable, Map<String, String> filters) {
        return null;
    }

    @Override
    public ResponseBalanceDTO findById(Long id) {
        Balance balance = balanceRepository.findByIdOrElseThrow(id);
        return responseBalanceMapper.toOT(balance);
    }

    @Override
    public ResponseBalanceDTO updateById(UpdateBalanceDTO updateDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        balanceRepository.deleteById(id);
    }
}
