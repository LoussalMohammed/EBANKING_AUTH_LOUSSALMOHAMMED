package org.roleApp.rollApp.loan.service;

import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.loan.dto.request.CreateLoanDTO;
import org.roleApp.rollApp.loan.dto.request.UpdateLoanDTO;
import org.roleApp.rollApp.loan.dto.response.ResponseLoanDTO;

public interface LoanService extends BaseService<Long, CreateLoanDTO, UpdateLoanDTO, ResponseLoanDTO> {
}
