package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.AmesDto;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class AmesValidator {

  public static List<String> validate(AmesDto amesDto) {
    List<String> errors = new ArrayList<>();

    if (amesDto == null) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
      errors.add("Veuillez renseigner le prenom d'utilisateur");
      errors.add("Veuillez renseigner le telephone d'utilisateur");
      return errors;
    }
    if (isEmpty(amesDto.getTelephone())) {
          errors.add("Veuillez renseigner le telephone d'utilisateur");
    }
    if (isEmpty(amesDto.getNom())) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
    }
    if (isEmpty(amesDto.getPrenom())) {
      errors.add("Veuillez renseigner le prenom d'utilisateur");
    }
    return errors;
  }

}
