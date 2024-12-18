package org.roleApp.rollApp.loan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.loan.dto.request.CreateLoanDTO;
import org.roleApp.rollApp.loan.dto.request.UpdateLoanDTO;
import org.roleApp.rollApp.loan.dto.response.ResponseLoanDTO;
import org.roleApp.rollApp.loan.entity.Loan;
import org.roleApp.rollApp.loan.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/loan")
@Slf4j
@RequiredArgsConstructor
public class LoanController extends BaseController<Loan, Long, CreateLoanDTO, UpdateLoanDTO, ResponseLoanDTO> {
    private final LoanService loanService;

    @Override
    protected BaseService<Long, CreateLoanDTO, UpdateLoanDTO, ResponseLoanDTO> getService() {
        return loanService;
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }
}
