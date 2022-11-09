package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.EmissionRepository;
import com.joeladjidan.sanctityoflord.repository.EnseignementRepository;
import com.joeladjidan.sanctityoflord.services.EmissionService;
import com.joeladjidan.sanctityoflord.services.EnseignementService;
import com.joeladjidan.sanctityoflord.validator.EmissionValidator;
import com.joeladjidan.sanctityoflord.validator.EnseignementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EmissionServiceImpl implements EmissionService {

  private EmissionRepository emissionRepository;

  @Autowired
  public EmissionServiceImpl(EmissionRepository emissionRepository) {
    this.emissionRepository = emissionRepository;
  }

  @Override
  public EmissionDto save(EmissionDto dto) {
    List<String> errors = EmissionValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Enseignement is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return EmissionDto.fromEntity(
            emissionRepository.save(
                EmissionDto.toEntity(dto)
        )
    );
  }

  @Override
  public EmissionDto findById(Integer id) {
    if (id == null) {
      log.error("Emission ID is null");
      return null;
    }
    return emissionRepository.findById(id)
        .map(EmissionDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune emission avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<EmissionDto> findAll() {
    return emissionRepository.findAll().stream()
        .map(EmissionDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Emission ID is null");
      return;
    }
    emissionRepository.deleteById(id);
  }
}
