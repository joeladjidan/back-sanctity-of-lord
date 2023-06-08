package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.AnneeDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.AnneeRepository;
import com.joeladjidan.sanctityoflord.services.AnneeService;
import com.joeladjidan.sanctityoflord.validator.AnneeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AnneeServiceImpl implements AnneeService {

  private AnneeRepository anneeRepository;

  @Autowired
  public AnneeServiceImpl(AnneeRepository anneeRepository) {
    this.anneeRepository = anneeRepository;
  }

  @Override
  public AnneeDto enregistrer(AnneeDto dto) {
    List<String> errors = AnneeValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return AnneeDto.fromEntity(
            anneeRepository.save(
              AnneeDto.toEntity(dto)
        )
    );
  }

  @Override
  public AnneeDto findById(Integer id) {
    if (id == null) {
      log.error("Annee ID is null");
      return null;
    }
    return anneeRepository.findById(id)
        .map(AnneeDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<AnneeDto> findAll() {
    return anneeRepository.findAll().stream()
        .map(AnneeDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
    anneeRepository.deleteById(id);
  }
}
