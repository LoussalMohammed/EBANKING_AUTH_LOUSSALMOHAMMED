package org.roleApp.rollApp.contact.mapper.response;

import org.mapstruct.Mapper;
import org.roleApp.rollApp.common.mapper.BaseMapper;
import org.roleApp.rollApp.contact.dto.response.EmbeddableContactDTO;
import org.roleApp.rollApp.contact.entity.Contact;

@Mapper(componentModel = "spring")
public interface EmbeddableContactMapper extends BaseMapper<Contact, EmbeddableContactDTO>  {
}
