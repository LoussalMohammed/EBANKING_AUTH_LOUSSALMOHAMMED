package org.roleApp.rollApp.card.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.roleApp.rollApp.card.dto.request.CreateCardDTO;
import org.roleApp.rollApp.card.dto.request.UpdateCardDTO;
import org.roleApp.rollApp.card.dto.response.ResponseCardDTO;
import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.card.mapper.request.CreateCardMapper;
import org.roleApp.rollApp.card.mapper.request.UpdateCardMapper;
import org.roleApp.rollApp.card.mapper.response.ResponseCardMapper;
import org.roleApp.rollApp.card.repository.CardRepository;
import org.roleApp.rollApp.card.service.CardService;
import org.roleApp.rollApp.shared.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final AppUserRepository userRepository;
    private final CreateCardMapper createCardMapper;
    private final UpdateCardMapper updateCardMapper;
    private final ResponseCardMapper responseCardMapper;


    @Override
    public ResponseCardDTO create(CreateCardDTO requestDTO) {
        AppUser user = userRepository.findByIdOrElseThrow(requestDTO.userId());
        Card card = createCardMapper.toE(requestDTO);
        card.setUser(user);
        user.setCard(card);
        cardRepository.save(card);
        return responseCardMapper.toOT(card);
    }

    @Override
    public PageResponse<ResponseCardDTO> findAll(Pageable pageable, Map<String, String> filters) {
        // Implement filtering logic if needed
        return null; // Placeholder
    }

    @Override
    public ResponseCardDTO findById(Long id) {
        Card card = cardRepository.findByIdOrElseThrow(id);
        return responseCardMapper.toOT(card);
    }

    @Override
    public ResponseCardDTO updateById(UpdateCardDTO updateDTO, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}
