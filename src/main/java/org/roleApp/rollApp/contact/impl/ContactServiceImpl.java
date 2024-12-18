package org.roleApp.rollApp.contact.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.card.mapper.request.CreateCardMapper;
import org.roleApp.rollApp.contact.dto.request.CreateContactDTO;
import org.roleApp.rollApp.contact.dto.request.UpdateContactDTO;
import org.roleApp.rollApp.contact.dto.response.ResponseContactDTO;
import org.roleApp.rollApp.contact.entity.Contact;
import org.roleApp.rollApp.contact.mapper.request.CreateContactMapper;
import org.roleApp.rollApp.contact.mapper.request.UpdateContactMapper;
import org.roleApp.rollApp.contact.mapper.response.ResponseContactMapper;
import org.roleApp.rollApp.contact.repository.ContactRepository;
import org.roleApp.rollApp.contact.service.ContactService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final CreateContactMapper createContactMapper;
    private final UpdateContactMapper updateContactMapper;
    private final ResponseContactMapper responseContactMapper;
    private final ContactRepository contactRepository;
    private final AppUserRepository userRepository;

    @Override
    public ResponseContactDTO create(CreateContactDTO requestDTO) {
        AppUser user = userRepository.findByIdOrElseThrow(requestDTO.userId());
        Contact contact = createContactMapper.toE(requestDTO);

        user.setContact(contact);
        contact.setUser(user);

        contactRepository.save(contact);
        return responseContactMapper.toOT(contact);
    }

    @Override
    public PageResponse<ResponseContactDTO> findAll(Pageable pageable, Map<String, String> filters) {
        return null;
    }

    @Override
    public ResponseContactDTO findById(Long id) {
        return responseContactMapper.toOT(contactRepository.findByIdOrElseThrow(id));
    }

    @Override
    public ResponseContactDTO updateById(UpdateContactDTO updateDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
