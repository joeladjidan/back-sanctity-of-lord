package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import com.joeladjidan.sanctityoflord.dto.VilleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VilleValidator {

  public static List<String> validate(VilleDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le nom de l'entreprise");
      errors.add("Veuillez reseigner la description de l'entreprise");
      errors.add("Veuillez reseigner le code fiscal de l'entreprise");
      errors.add("Veuillez reseigner l'email de l'entreprise");
      errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
      errors.addAll(ArtisteValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(dto.getIntitule())) {
      errors.add("Veuillez renseigner l'intitule du type d'enseignement");
    }
    if (!StringUtils.hasLength(dto.getDescription())) {
      errors.add("Veuillez reseigner la description du type d'enseignement");
    }
    return errors;
  }

}
