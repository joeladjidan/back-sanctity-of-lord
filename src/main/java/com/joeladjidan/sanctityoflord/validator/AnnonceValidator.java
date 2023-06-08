package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.AnnonceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AnnonceValidator {

  public static List<String> validate(AnnonceDto annonceDto) {
    List<String> errors = new ArrayList<>();

    if (annonceDto == null) {
        errors.add("Veuillez renseigner la description");
        errors.add("Veuillez renseigner la description");
      return errors;
    }

    if (!StringUtils.hasLength(annonceDto.getUrl())) {
         errors.add("Veuillez renseigner l'url");
    }
    if (!StringUtils.hasLength(annonceDto.getIntitule())) {
      errors.add("Veuillez renseigner l'intitule");
    }
    return errors;
  }

}
