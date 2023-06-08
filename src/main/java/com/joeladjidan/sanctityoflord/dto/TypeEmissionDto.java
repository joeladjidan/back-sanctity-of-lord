package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.TypeEmission;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class TypeEmissionDto {

  private int id;
  private String intitule;
  private String description;

  public static TypeEmissionDto fromEntity(TypeEmission typeEmission) {
    if (typeEmission == null) {
        return null;
    }

    return TypeEmissionDto.builder()
        .id(typeEmission.getId())
        .intitule(typeEmission.getIntitule())
        .description(typeEmission.getDescription())
        .build();
  }

  public static TypeEmission toEntity(TypeEmissionDto dto) {
    if (dto == null) {
        return null;
    }
      TypeEmission typeEmission = new TypeEmission();
      typeEmission.setId(dto.getId());
      typeEmission.setIntitule(dto.getIntitule());
      typeEmission.setDescription(dto.getDescription());
      return typeEmission;
  }

}
