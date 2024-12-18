package org.roleApp.rollApp.loan.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.loan.dto.response.EmbeddableLoanDTO;
import org.roleApp.rollApp.loan.entity.Loan;

@Mapper(componentModel = "spring")
public interface EmbeddableLoanMapper extends BaseMapper<Loan, EmbeddableLoanDTO> {
}