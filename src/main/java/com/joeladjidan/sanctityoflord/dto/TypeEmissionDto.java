package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.TypeEmission;
import com.joeladjidan.sanctityoflord.model.TypeEnseignement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeEmissionDto {

  private String intitule;
  private String description;

  public static TypeEmissionDto fromEntity(TypeEmission typeEmission) {
    if (typeEmission == null) {
        return null;
    }

    return TypeEmissionDto.builder()
        .intitule(typeEmission.getIntitule())
        .description(typeEmission.getDescription())
        .build();
  }

  public static TypeEmission toEntity(TypeEmissionDto dto) {
    if (dto == null) {
        return null;
    }
      TypeEmission typeEmission = new TypeEmission();
      typeEmission.setIntitule(dto.getIntitule());
      typeEmission.setDescription(dto.getDescription());
      return typeEmission;
  }

}
