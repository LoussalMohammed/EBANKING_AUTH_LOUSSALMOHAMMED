package org.roleApp.rollApp.contact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.common.controller.BaseController;
import org.roleApp.rollApp.common.service.BaseService;
import org.roleApp.rollApp.contact.dto.request.CreateContactDTO;
import org.roleApp.rollApp.contact.dto.request.UpdateContactDTO;
import org.roleApp.rollApp.contact.dto.response.ResponseContactDTO;
import org.roleApp.rollApp.contact.entity.Contact;
import org.roleApp.rollApp.contact.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/contact")
@Slf4j
@RequiredArgsConstructor
public class ContactController extends BaseController<Contact,Long, CreateContactDTO, UpdateContactDTO, ResponseContactDTO> {
    private final ContactService contactService;

    @Override
    protected BaseService<Long, CreateContactDTO, UpdateContactDTO, ResponseContactDTO> getService() {
        return contactService;
    }

    @Override
    public Class<Contact> getEntityClass() {
        return Contact.class;
    }
}
