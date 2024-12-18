package org.roleApp.rollApp.loan.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.loan.dto.request.CreateLoanDTO;
import org.roleApp.rollApp.loan.dto.request.UpdateLoanDTO;
import org.roleApp.rollApp.loan.dto.response.ResponseLoanDTO;
import org.roleApp.rollApp.loan.entity.Loan;
import org.roleApp.rollApp.loan.mapper.request.CreateLoanMapper;
import org.roleApp.rollApp.loan.mapper.request.UpdateLoanMapper;
import org.roleApp.rollApp.loan.mapper.response.ResponseLoanMapper;
import org.roleApp.rollApp.loan.repository.LoanRepository;
import org.roleApp.rollApp.loan.service.LoanService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final AppUserRepository userRepository;
    private final CreateLoanMapper createLoanMapper;
    private final UpdateLoanMapper updateLoanMapper;
    private final ResponseLoanMapper responseLoanMapper;

    @Override
    public ResponseLoanDTO create(CreateLoanDTO requestDTO) {
        AppUser user = userRepository.findByIdOrElseThrow(requestDTO.userId());
        Loan loan = createLoanMapper.toE(requestDTO);

        loan.setUser(user);
        user.getLoans().add(loan);

        loanRepository.save(loan);
        return responseLoanMapper.toOT(loan);
    }

    @Override
    public PageResponse<ResponseLoanDTO> findAll(Pageable pageable, Map<String, String> filters) {
        // Implement filtering logic if needed
        return null; // Placeholder
    }

    @Override
    public ResponseLoanDTO findById(Long id) {
        Loan loan = loanRepository.findByIdOrElseThrow(id);
        return responseLoanMapper.toOT(loan);
    }

    @Override
    public ResponseLoanDTO updateById(UpdateLoanDTO updateDTO, Long id) {

        return null;
    }

    @Override
    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}
