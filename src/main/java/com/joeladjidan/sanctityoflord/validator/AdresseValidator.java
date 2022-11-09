package com.joeladjidan.sanctityoflord.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

import com.joeladjidan.sanctityoflord.dto.AdresseDto;

public class AdresseValidator {

  public static List<String> validate(AdresseDto adresseDto) {
    List<String> errors = new ArrayList<>();

    if (adresseDto == null) {
      errors.add("Veuillez renseigner l'adresse 1'");
      errors.add("Veuillez renseigner le code postal'");
      errors.addAll(AdresseValidator.validate(null));
      errors.addAll(AdresseValidator.validate(null));
      return errors;
    }
    if (!StringUtils.hasLength(adresseDto.getAdresse1())) {
      errors.add("Veuillez renseigner l'adresse 1'");
    }
    if (!StringUtils.hasLength(adresseDto.getAdresse1())) {
      errors.add("Veuillez renseigner le code postal'");
    }
  //  errors.addAll(AdresseValidator.validate(adresseDto.getVille()));
  //  errors.addAll(AdresseValidator.validate(adresseDto.getPays()));
    return errors;
  }

}
