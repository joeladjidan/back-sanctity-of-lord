package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.ChangerMotDePasseUtilisateurDto;
import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import com.joeladjidan.sanctityoflord.dto.UtilisateurDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.exception.InvalidOperationException;
import com.joeladjidan.sanctityoflord.repository.GalerieRepository;
import com.joeladjidan.sanctityoflord.services.GalerieService;
import com.joeladjidan.sanctityoflord.validator.GalerieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
  public GalerieDto save(GalerieDto dto) {
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
  public void delete(Integer id) {
    if (id == null) {
      log.error("Galerie ID is null");
      return;
    }
    galerieRepository.deleteById(id);
  }


  private void validate(ChangerMotDePasseUtilisateurDto dto) {
    if (dto == null) {
      log.warn("Impossible de modifier le mot de passe avec un objet NULL");
      throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
    }
    if (dto.getId() == null) {
      log.warn("Impossible de modifier le mot de passe avec un ID NULL");
      throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
    }
    if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
      log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
      throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
    }
    if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
      log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
      throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
          ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
    }
  }
}
