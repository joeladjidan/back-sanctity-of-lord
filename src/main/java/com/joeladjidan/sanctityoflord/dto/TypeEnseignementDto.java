package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class TypeEnseignementDto {

  private int id;
  private String intitule;
  private String description;

  public static TypeEnseignementDto fromEntity(TypeEnseignement typeEnseignement) {
    if (typeEnseignement == null) {
        return null;
    }

    return TypeEnseignementDto.builder()
        .id(typeEnseignement.getId())
        .intitule(typeEnseignement.getIntitule())
        .description(typeEnseignement.getDescription())
        .build();
  }

  public static TypeEnseignement toEntity(TypeEnseignementDto dto) {
    if (dto == null) {
        return null;
    }
    TypeEnseignement typeEnseignement = new TypeEnseignement();
      typeEnseignement.setId(dto.getId());
      typeEnseignement.setIntitule(dto.getIntitule());
      typeEnseignement.setDescription(dto.getDescription());
      return typeEnseignement;
  }

}
