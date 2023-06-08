package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.CiviliteDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.CiviliteRepository;
import com.joeladjidan.sanctityoflord.services.CiviliteService;
import com.joeladjidan.sanctityoflord.validator.CiviliteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CiviliteServiceImpl implements CiviliteService {

  private CiviliteRepository civiliteRepository;

  @Autowired
  public CiviliteServiceImpl(CiviliteRepository civiliteRepository) {
    this.civiliteRepository = civiliteRepository;
  }

  @Override
  public CiviliteDto enregistrer(CiviliteDto dto) {
    List<String> errors = CiviliteValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Civilite is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return CiviliteDto.fromEntity(
            civiliteRepository.save(
              CiviliteDto.toEntity(dto)
        )
    );
  }

  @Override
  public CiviliteDto findById(Integer id) {
    if (id == null) {
      log.error("Civilite ID is null");
      return null;
    }
    return civiliteRepository.findById(id)
        .map(CiviliteDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<CiviliteDto> findAll() {
    return civiliteRepository.findAll().stream()
        .map(CiviliteDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Civilite ID is null");
      return;
    }
    civiliteRepository.deleteById(id);
  }
}
