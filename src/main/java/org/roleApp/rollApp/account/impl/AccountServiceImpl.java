package org.roleApp.rollApp.account.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.account.dto.request.CreateAccountDTO;
import org.roleApp.rollApp.account.dto.request.UpdateAccountDTO;
import org.roleApp.rollApp.account.dto.response.ResponseAccountDTO;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.account.mapper.request.CreateAccountMapper;
import org.roleApp.rollApp.account.mapper.request.UpdateAccountMapper;
import org.roleApp.rollApp.account.mapper.response.ResponseAccountMapper;
import org.roleApp.rollApp.account.repository.AccountRepository;
import org.roleApp.rollApp.account.service.AccountService;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.balance.entity.Balance;
import org.roleApp.rollApp.balance.repository.BalanceRepository;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final AppUserRepository userRepository;
    private final CreateAccountMapper createAccountMapper;
    private final UpdateAccountMapper updateAccountMapper;
    private final ResponseAccountMapper responseAccountMapper;

    @Override
    public ResponseAccountDTO create(CreateAccountDTO requestDTO) {
        Long userId = requestDTO.userId();

        Account account = createAccountMapper.toE(requestDTO);
        AppUser user = userRepository.findByIdOrElseThrow(userId);


        account.setUser(user);
        user.getAccounts().add(account);

        accountRepository.save(account);
        return responseAccountMapper.toOT(account);
    }

    @Override
    public PageResponse<ResponseAccountDTO> findAll(Pageable pageable, Map<String, String> filters) {
        // Implement filtering logic if needed
        return null; // Placeholder
    }

    @Override
    public ResponseAccountDTO findById(Long id) {
        Account account = accountRepository.findByIdOrElseThrow(id);
        return responseAccountMapper.toOT(account);
    }

    @Override
    public ResponseAccountDTO updateById(UpdateAccountDTO updateDTO, Long id) {

        return null;
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }


}
