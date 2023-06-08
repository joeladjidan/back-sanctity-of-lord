package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.CodePostaleDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.CodePostaleRepository;
import com.joeladjidan.sanctityoflord.services.CodePostaleService;
import com.joeladjidan.sanctityoflord.validator.CodePostaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CodePostaleServiceImpl implements CodePostaleService {

  private CodePostaleRepository codePostaleRepository;

  @Autowired
  public CodePostaleServiceImpl(CodePostaleRepository codePostaleRepository) {
    this.codePostaleRepository = codePostaleRepository;
  }

  @Override
  public CodePostaleDto enregistrer(CodePostaleDto dto) {
    List<String> errors = CodePostaleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return CodePostaleDto.fromEntity(
            codePostaleRepository.save(
                    CodePostaleDto.toEntity(dto)
        )
    );
  }

  @Override
  public CodePostaleDto findById(Integer id) {
    if (id == null) {
      log.error("Annee ID is null");
      return null;
    }
    return codePostaleRepository.findById(id)
        .map(CodePostaleDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<CodePostaleDto> findAll() {
    return codePostaleRepository.findAll().stream()
        .map(CodePostaleDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
    codePostaleRepository.deleteById(id);
  }
}
