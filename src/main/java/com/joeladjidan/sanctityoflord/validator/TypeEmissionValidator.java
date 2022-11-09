package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.TypeEmissionDto;
import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TypeEmissionValidator {

  public static List<String> validate(TypeEmissionDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le nom de l'entreprise");
      errors.add("Veuillez reseigner la description de l'entreprise");
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
