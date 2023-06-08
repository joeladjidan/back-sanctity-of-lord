package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.PaysDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.PaysRepository;
import com.joeladjidan.sanctityoflord.services.PaysService;
import com.joeladjidan.sanctityoflord.validator.PaysValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class PaysServiceImpl implements PaysService {

  private PaysRepository paysRepository;

  @Autowired
  public PaysServiceImpl(PaysRepository paysRepository) {
    this.paysRepository = paysRepository;
  }

  @Override
  public PaysDto enregistrer(PaysDto dto) {
    List<String> errors = PaysValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return PaysDto.fromEntity(
            paysRepository.save(
              PaysDto.toEntity(dto)
        )
    );
  }

  @Override
  public PaysDto findById(Integer id) {
    if (id == null) {
       log.error("Pays ID is null");
       return null;
    }
    return paysRepository.findById(id)
        .map(PaysDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<PaysDto> findAll() {
    return paysRepository.findAll().stream()
        .map(PaysDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Pays ID is null");
      return;
    }
    paysRepository.deleteById(id);
  }
}
