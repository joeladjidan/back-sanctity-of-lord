package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.AnnonceDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.InformationRepository;
import com.joeladjidan.sanctityoflord.services.AnnonceService;
import com.joeladjidan.sanctityoflord.validator.AnnonceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AnnonceServiceImpl implements AnnonceService {

  private InformationRepository informationRepository;

  @Autowired
  public AnnonceServiceImpl(InformationRepository informationRepository) {
    this.informationRepository = informationRepository;
  }

  @Override
  public AnnonceDto enregistrer(AnnonceDto dto) {
    List<String> errors = AnnonceValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Annonce is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return AnnonceDto.fromEntity(
            informationRepository.save(
          AnnonceDto.toEntity(dto)
        )
    );
  }

  @Override
  public AnnonceDto findById(Integer id) {
    if (id == null) {
      log.error("Annonce ID is null");
      return null;
    }
    return informationRepository.findById(id)
        .map(AnnonceDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune information avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<AnnonceDto> findAll() {
    return informationRepository.findAll().stream()
        .map(AnnonceDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Annonce ID is null");
      return;
    }
    informationRepository.deleteById(id);
  }
}
