package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.TypeEmissionDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.TypeEmissionRepository;
import com.joeladjidan.sanctityoflord.repository.TypeEnseignementRepository;
import com.joeladjidan.sanctityoflord.services.TypeEmissionService;
import com.joeladjidan.sanctityoflord.validator.TypeEmissionValidator;
import com.joeladjidan.sanctityoflord.validator.TypeEnseignementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TypeEmissionServiceImpl implements TypeEmissionService {

  private TypeEmissionRepository typeEmissionRepository;

  @Autowired
  public TypeEmissionServiceImpl(TypeEmissionRepository typeEmissionRepository) {
    this.typeEmissionRepository = typeEmissionRepository;
  }

  @Override
  public TypeEmissionDto save(TypeEmissionDto dto) {
    List<String> errors = TypeEmissionValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Enseignement is not valid {}", dto);
      throw new InvalidEntityException("L'enseignement n'est pas valide", ErrorCodes.TYPE_EMISSION_NOT_VALID, errors);
    }

    return TypeEmissionDto.fromEntity(
        typeEmissionRepository.save(
                TypeEmissionDto.toEntity(dto)
        )
    );
  }

  @Override
  public TypeEmissionDto findById(Integer id) {
    if (id == null) {
      log.error("Type d'enseignement ID is null");
      return null;
    }
    return typeEmissionRepository.findById(id)
        .map(TypeEmissionDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun enseignement avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<TypeEmissionDto> findAll() {
    return typeEmissionRepository.findAll().stream()
        .map(TypeEmissionDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Enseignement ID is null");
      return;
    }
    typeEmissionRepository.deleteById(id);
  }
}
