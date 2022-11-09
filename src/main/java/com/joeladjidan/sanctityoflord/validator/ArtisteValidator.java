package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.ArtisteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ArtisteValidator {

  public static List<String> validate(ArtisteDto artisteDto) {
    List<String> errors = new ArrayList<>();

    if (artisteDto == null) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
      errors.add("Veuillez renseigner le prenom d'utilisateur");
      return errors;
    }

    if (!StringUtils.hasLength(artisteDto.getEmail())) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
    }
    if (!StringUtils.hasLength(artisteDto.getNom())) {
      errors.add("Veuillez renseigner le prenom d'utilisateur");
    }
    if (isEmpty(artisteDto.getPhoto())) {
      errors.add("Veuillez renseigner le prenom d'utilisateur");
    }
    if (isEmpty(artisteDto.getDateDeNaissance())) {
      errors.add("Veuillez renseigner le prenom d'utilisateur");
    }
    if (isEmpty(artisteDto.getPrenom())) {
      errors.add("Veuillez renseigner le prenom d'utilisateur");
    }
    return errors;
  }

}
