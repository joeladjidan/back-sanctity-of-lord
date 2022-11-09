package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class GalerieValidator {

  public static List<String> validate(GalerieDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.addAll(DonneeValidator.validate(null));
      errors.add("Veuillez renseigner l'intitule de la galerie");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getIntitule())) {
        errors.add("Veuillez renseigner l'intitule");
    }
    errors.addAll(DonneeValidator.validate(dto.getDonnee()));
    return errors;
  }

}
