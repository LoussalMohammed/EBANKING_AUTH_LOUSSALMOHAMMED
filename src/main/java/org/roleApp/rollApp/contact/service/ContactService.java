package org.roleApp.rollApp.contact.service;

import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.contact.dto.request.CreateContactDTO;
import org.roleApp.rollApp.contact.dto.request.UpdateContactDTO;
import org.roleApp.rollApp.contact.dto.response.ResponseContactDTO;

public interface ContactService extends BaseService<Long, CreateContactDTO, UpdateContactDTO, ResponseContactDTO> {
}
