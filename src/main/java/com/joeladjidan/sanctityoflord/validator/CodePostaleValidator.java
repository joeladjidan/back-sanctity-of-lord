package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.CodePostaleDto;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class CodePostaleValidator {

  public static List<String> validate(CodePostaleDto codePostaleDto) {
    List<String> errors = new ArrayList<>();

    if (codePostaleDto == null) {
      errors.add("Veuillez renseigner le code postale");
      return errors;
    }
    if (isEmpty(codePostaleDto.getCode())) {
          errors.add("Veuillez renseigner l'email d'utilisateur");
    }
    return errors;
  }

}
