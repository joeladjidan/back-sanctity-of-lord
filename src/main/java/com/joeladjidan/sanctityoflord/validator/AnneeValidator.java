package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.AnneeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class AnneeValidator {

  public static List<String> validate(AnneeDto anneeDto) {
    List<String> errors = new ArrayList<>();

    if (anneeDto == null) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
      errors.add("Veuillez renseigner le prenom d'utilisateur");
      return errors;
    }

    if (!StringUtils.hasLength(anneeDto.getIntitule())) {
      errors.add("Veuillez renseigner l'intitule");
    }
    return errors;
  }

}
