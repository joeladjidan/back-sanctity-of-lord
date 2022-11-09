package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.EnseignementRepository;
import com.joeladjidan.sanctityoflord.services.EnseignementService;
import com.joeladjidan.sanctityoflord.validator.EnseignementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EnseignementServiceImpl implements EnseignementService {

  private EnseignementRepository enseignementRepository;

  @Autowired
  public EnseignementServiceImpl(EnseignementRepository enseignementRepository) {
    this.enseignementRepository = enseignementRepository;
  }

  @Override
  public EnseignementDto save(EnseignementDto dto) {
    List<String> errors = EnseignementValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Enseignement is not valid {}", dto);
      throw new InvalidEntityException("L'enseignement n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return EnseignementDto.fromEntity(
        enseignementRepository.save(
                EnseignementDto.toEntity(dto)
        )
    );
  }

  @Override
  public EnseignementDto findById(Integer id) {
    if (id == null) {
      log.error("Enseignement ID is null");
      return null;
    }
    return enseignementRepository.findById(id)
        .map(EnseignementDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun enseignement avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<EnseignementDto> findAll() {
    return enseignementRepository.findAll().stream()
        .map(EnseignementDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Enseignement ID is null");
      return;
    }
    enseignementRepository.deleteById(id);
  }
}
