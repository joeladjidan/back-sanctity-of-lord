package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.ContactDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactValidator {

  public static List<String> validate(ContactDto contactDto) {
    List<String> errors = new ArrayList<>();

    if (contactDto == null) {
      errors.add("Veuillez renseigner l'adresse 1'");
      errors.add("Veuillez renseigner le code postal'");
      errors.addAll(ContactValidator.validate(null));
      errors.addAll(ContactValidator.validate(null));
      return errors;
    }
    if (!StringUtils.hasLength(contactDto.getMessage())) {
      errors.add("Veuillez renseigner l'adresse 1'");
    }
    if (!StringUtils.hasLength(contactDto.getNom())) {
      errors.add("Veuillez renseigner le nom'");
    }
    if (!StringUtils.hasLength(contactDto.getPrenom())) {
      errors.add("Veuillez renseigner le prenom'");
    }
    return errors;
  }

}
