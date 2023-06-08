package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.DonneeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DonneeValidator {

  public static List<String> validate(DonneeDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le nom du fichier");
      errors.add("Veuillez reseigner l'url du fichier");
      errors.add("Veuillez reseigner la taille du fichier");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getFileName())) {
      errors.add("Veuillez renseigner l'intitule du type d'enseignement");
    }
    if (!StringUtils.hasLength(dto.getUrl())) {
      errors.add("Veuillez renseigner l'intitule du type d'enseignement");
    }
    return errors;
  }

}
