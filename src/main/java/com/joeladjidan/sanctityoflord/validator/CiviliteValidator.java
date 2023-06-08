package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.CiviliteDto;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class CiviliteValidator {

  public static List<String> validate(CiviliteDto civiliteDto) {
    List<String> errors = new ArrayList<>();

    if (civiliteDto == null) {
      errors.add("Veuillez renseigner l'intitule");
      return errors;
    }

    if (isEmpty(civiliteDto.getIntitule())) {
      errors.add("Veuillez renseigner l'intitule");
    }
    return errors;
  }

}
