package org.roleApp.rollApp.contact.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.contact.dto.response.ResponseContactDTO;
import org.roleApp.rollApp.contact.entity.Contact;

@Mapper(componentModel = "spring")
public interface ResponseContactMapper extends BaseMapper<Contact, ResponseContactDTO> {
}
