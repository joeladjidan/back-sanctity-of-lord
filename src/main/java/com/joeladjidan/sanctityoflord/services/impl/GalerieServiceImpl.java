package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.GalerieRepository;
import com.joeladjidan.sanctityoflord.services.GalerieService;
import com.joeladjidan.sanctityoflord.utils.Constants;
import com.joeladjidan.sanctityoflord.validator.GalerieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class GalerieServiceImpl implements GalerieService {

  private GalerieRepository galerieRepository;

  @Autowired
  public GalerieServiceImpl(GalerieRepository galerieRepository,
                            PasswordEncoder passwordEncoder) {
    this.galerieRepository = galerieRepository;
  }

  @Override
  public GalerieDto enregistrer(GalerieDto dto) {
    List<String> errors = GalerieValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Galerie is not valid {}", dto);
      throw new InvalidEntityException("La galerie n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return GalerieDto.fromEntity(
        galerieRepository.save(
                GalerieDto.toEntity(dto)
        )
    );
  }

  @Override
  public GalerieDto findById(Integer id) {
    if (id == null) {
      log.error("Utilisateur ID is null");
      return null;
    }
    return galerieRepository.findById(id)
        .map(GalerieDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<GalerieDto> findAll() {
    return galerieRepository.findAll().stream()
        .map(GalerieDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Galerie ID is null");
      return;
    }
    galerieRepository.deleteById(id);
  }

  @Override
  public GalerieDto modifier(Integer id, GalerieDto dto) {
    List<String> errors = GalerieValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("La galerie n'est pas valide {}", dto);
      throw new InvalidEntityException("Le contact n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    if (id == null) {
      log.error("L'identifiant de la galerie est null");
      return null;
    }
    GalerieDto dtoUpdate = findById(id);

    if (dtoUpdate != null)
    {
      dtoUpdate.setIntitule(dto.getIntitule());
      dtoUpdate.setDonnee(dto.getDonnee());
    }
    return GalerieDto.fromEntity(
        galerieRepository.save(
                GalerieDto.toEntity(dtoUpdate)
        )
    );
  }

  @Override
  public void enregistreImage(MultipartFile file) {
    try {
      Path root = Paths.get(Constants.REPERTOIRE_FICHIER);
      Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

}
