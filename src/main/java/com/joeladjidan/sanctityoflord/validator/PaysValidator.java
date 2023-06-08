package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.PaysDto;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class PaysValidator {

  public static List<String> validate(PaysDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner l'intitule");
  //    errors.addAll(ArtisteValidator.validate(null));
      return errors;
    }

    if (isEmpty(dto.getIntitule())) {
        errors.add("Veuillez renseigner l'intitule");
    }
    return errors;
  }

}
