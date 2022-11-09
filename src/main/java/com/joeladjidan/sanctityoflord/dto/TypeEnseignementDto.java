package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeEnseignementDto {

  private String intitule;
  private String description;

  public static TypeEnseignementDto fromEntity(TypeEnseignement typeEnseignement) {
    if (typeEnseignement == null) {
        return null;
    }

    return TypeEnseignementDto.builder()
        .intitule(typeEnseignement.getIntitule())
        .description(typeEnseignement.getDescription())
        .build();
  }

  public static TypeEnseignement toEntity(TypeEnseignementDto dto) {
    if (dto == null) {
        return null;
    }
    TypeEnseignement typeEnseignement = new TypeEnseignement();
      typeEnseignement.setIntitule(dto.getIntitule());
      typeEnseignement.setDescription(dto.getDescription());
      return typeEnseignement;
  }

}
