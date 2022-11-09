package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class ArchivreValidator {

  public static List<String> validate(ArchivreDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le nom de l'entreprise");
      errors.add("Veuillez reseigner la description de l'entreprise");
      errors.add("Veuillez reseigner le code fiscal de l'entreprise");
      errors.add("Veuillez reseigner l'email de l'entreprise");
      errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
      errors.addAll(ArtisteValidator.validate(null));
      return errors;
    }

    /*if (!StringUtils.hasLength(dto.getDateArchivre())) {
      errors.add("Veuillez renseigner le nom de l'entreprise");
    }
    if (!StringUtils.hasLength(dto.getLien())) {
          errors.add("Veuillez renseigner le nom de l'entreprise");
    }
    if (!isValid(dto.getDateEmission().toString())) {
        errors.add("Veuillez renseigner la date");
    }
    if (!StringUtils.hasLength(dto.getDescription())) {
      errors.add("Veuillez reseigner la description de l'emission");
    }
    if (!StringUtils.hasLength(dto.getIntitule())) {
      errors.add("Veuillez reseigner l'intitule de l'emission");
    }*/
    return errors;
  }

  public static boolean isValid(final String date) {
    boolean valid = false;
    try {
      // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
      LocalDate.parse(date,
              DateTimeFormatter.ofPattern("uuuu-M-d")
                      .withResolverStyle(ResolverStyle.STRICT)
      );

      valid = true;

    } catch (DateTimeParseException e) {
      e.printStackTrace();
      valid = false;
    }
    return valid;
  }

}
