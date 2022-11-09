package com.joeladjidan.sanctityoflord.validator;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EnseignementValidator {

  public static List<String> validate(EnseignementDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.addAll(TitreMessageValidator.validate(null));
      errors.addAll(TypeEnseignementValidator.validate(null));
      errors.addAll(TypeEmissionValidator.validate(null));
      return errors;
    }
    if (!StringUtils.hasLength(dto.getTitreMessage().getIntitule())) {
        errors.addAll(TitreMessageValidator.validate(dto.getTitreMessage()));
    }
    if (!StringUtils.hasLength(dto.getTitreMessage().getIntitule())) {
      errors.addAll(TypeEnseignementValidator.validate(dto.getTypeEnseignement()));
    }
    if (!StringUtils.hasLength(dto.getTitreMessage().getIntitule())) {
        errors.addAll(TypeEmissionValidator.validate(dto.getTypeEmission()));
    }
    return errors;
  }

}
