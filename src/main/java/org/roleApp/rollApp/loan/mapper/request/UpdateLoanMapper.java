package org.roleApp.rollApp.loan.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.loan.dto.request.UpdateLoanDTO;
import org.roleApp.rollApp.loan.entity.Loan;

@Mapper(componentModel = "spring")
public interface UpdateLoanMapper extends BaseMapper<Loan, UpdateLoanDTO> {
}
