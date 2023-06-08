package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.AdresseDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.AdresseRepository;
import com.joeladjidan.sanctityoflord.services.AdresseService;
import com.joeladjidan.sanctityoflord.validator.AdresseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AdresseServiceImpl implements AdresseService {

  private AdresseRepository adresseRepository;

  @Autowired
  public AdresseServiceImpl(AdresseRepository adresseRepository) {
    this.adresseRepository = adresseRepository;
  }

  @Override
  public AdresseDto enregistrer(AdresseDto dto) {
    List<String> errors = AdresseValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return AdresseDto.fromEntity(
            adresseRepository.save(
                  AdresseDto.toEntity(dto)
        )
    );
  }

  @Override
  public AdresseDto findById(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return null;
    }
    return adresseRepository.findById(id)
        .map(AdresseDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune adresse avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<AdresseDto> findAll() {
    return adresseRepository.findAll()
        .stream()
        .map(AdresseDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
    adresseRepository.deleteById(id);
  }
}
