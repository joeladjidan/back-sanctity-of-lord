package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.VilleDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.VilleRepository;
import com.joeladjidan.sanctityoflord.services.VilleService;
import com.joeladjidan.sanctityoflord.validator.VilleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class VilleServiceImpl implements VilleService {

  private VilleRepository villeRepository;

  @Autowired
  public VilleServiceImpl(VilleRepository villeRepository) {
    this.villeRepository = villeRepository;
  }

  @Override
  public VilleDto enregistrer(VilleDto dto) {
    List<String> errors = VilleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return VilleDto.fromEntity(
            villeRepository.save(
                    VilleDto.toEntity(dto)
        )
    );
  }

  @Override
  public VilleDto findById(Integer id) {
    if (id == null) {
       log.error("Pays ID is null");
       return null;
    }
    return villeRepository.findById(id)
        .map(VilleDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<VilleDto> findAll() {
    return villeRepository.findAll().stream()
        .map(VilleDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Pays ID is null");
      return;
    }
    villeRepository.deleteById(id);
  }
}
