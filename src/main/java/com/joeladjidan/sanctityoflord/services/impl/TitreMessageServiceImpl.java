package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.TitreMessageDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.TitreMessageRepository;
import com.joeladjidan.sanctityoflord.services.TitreMessageService;
import com.joeladjidan.sanctityoflord.validator.TitreMessageValidator;
import com.joeladjidan.sanctityoflord.validator.TypeEnseignementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TitreMessageServiceImpl implements TitreMessageService {

  private TitreMessageRepository titreMessageRepository;

  @Autowired
  public TitreMessageServiceImpl(TitreMessageRepository titreMessageRepository) {
    this.titreMessageRepository = titreMessageRepository;
  }

  @Override
  public TitreMessageDto save(TitreMessageDto dto) {
    List<String> errors = TitreMessageValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("le titre de message is not valid {}", dto);
      throw new InvalidEntityException("L'enseignement n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return TitreMessageDto.fromEntity(
        titreMessageRepository.save(
                TitreMessageDto.toEntity(dto)
        )
    );
  }

  @Override
  public TitreMessageDto findById(Integer id) {
    if (id == null) {
      log.error("Type d'enseignement ID is null");
      return null;
    }
    return titreMessageRepository.findById(id)
        .map(TitreMessageDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun enseignement avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<TitreMessageDto> findAll() {
    return titreMessageRepository.findAll().stream()
        .map(TitreMessageDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Enseignement ID is null");
      return;
    }
    titreMessageRepository.deleteById(id);
  }
}
