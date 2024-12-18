package org.roleApp.rollApp.contact.mapper.request;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.contact.dto.request.UpdateContactDTO;
import org.roleApp.rollApp.contact.entity.Contact;

@Mapper(componentModel = "spring")
public interface UpdateContactMapper extends BaseMapper<Contact, UpdateContactDTO> {
}
