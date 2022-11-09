package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.EnseignementRepository;
import com.joeladjidan.sanctityoflord.repository.TypeEnseignementRepository;
import com.joeladjidan.sanctityoflord.services.EnseignementService;
import com.joeladjidan.sanctityoflord.services.TypeEnseignementService;
import com.joeladjidan.sanctityoflord.validator.EnseignementValidator;
import com.joeladjidan.sanctityoflord.validator.TypeEnseignementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TypeEnseignementServiceImpl implements TypeEnseignementService {

  private TypeEnseignementRepository typeEnseignementRepository;

  @Autowired
  public TypeEnseignementServiceImpl(TypeEnseignementRepository typeEnseignementRepository) {
    this.typeEnseignementRepository = typeEnseignementRepository;
  }

  @Override
  public TypeEnseignementDto save(TypeEnseignementDto dto) {
    List<String> errors = TypeEnseignementValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Enseignement is not valid {}", dto);
      throw new InvalidEntityException("L'enseignement n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return TypeEnseignementDto.fromEntity(
        typeEnseignementRepository.save(
                TypeEnseignementDto.toEntity(dto)
        )
    );
  }

  @Override
  public TypeEnseignementDto findById(Integer id) {
    if (id == null) {
      log.error("Type d'enseignement ID is null");
      return null;
    }
    return typeEnseignementRepository.findById(id)
        .map(TypeEnseignementDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun enseignement avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<TypeEnseignementDto> findAll() {
    return typeEnseignementRepository.findAll().stream()
        .map(TypeEnseignementDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Enseignement ID is null");
      return;
    }
    typeEnseignementRepository.deleteById(id);
  }
}
