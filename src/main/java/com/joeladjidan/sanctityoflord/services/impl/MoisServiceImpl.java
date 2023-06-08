package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.MoisDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.MoisRepository;
import com.joeladjidan.sanctityoflord.services.MoisService;
import com.joeladjidan.sanctityoflord.validator.MoisValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class MoisServiceImpl implements MoisService {

  private MoisRepository moisRepository;

  @Autowired
  public MoisServiceImpl(MoisRepository moisRepository) {
    this.moisRepository = moisRepository;
  }

  @Override
  public MoisDto enregistrer(MoisDto dto) {
    List<String> errors = MoisValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return MoisDto.fromEntity(
            moisRepository.save(
              MoisDto.toEntity(dto)
        )
    );
  }

  @Override
  public MoisDto findById(Integer id) {
    if (id == null) {
      log.error("Mois ID is null");
      return null;
    }
    return moisRepository.findById(id)
        .map(MoisDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun mois avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<MoisDto> findAll() {
    return moisRepository.findAll().stream()
        .map(MoisDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Mois ID is null");
      return;
    }
    moisRepository.deleteById(id);
  }
}
