package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.Emission;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class EmissionDto {

  private Integer id;
  private String description;
  private Date dateEmission;
  private DonneeDto donnee;
  private TypeEmissionDto typeEmission;

  public static EmissionDto fromEntity(Emission emission) {
    if (emission == null) {
        return null;
    }
    return EmissionDto.builder()
        .id(emission.getId())
        .description(emission.getDescription())
        .dateEmission(emission.getDateEmission())
        .donnee(DonneeDto.fromEntity(emission.getDonnee()))
        .typeEmission(TypeEmissionDto.fromEntity(emission.getTypeEmission()))
        .build();
  }

  public static Emission toEntity(EmissionDto dto) {
    if (dto == null) {
        return null;
    }
    Emission emission = new Emission();
    emission.setId(dto.getId());
    emission.setDateEmission(dto.getDateEmission());
    emission.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
    emission.setTypeEmission(TypeEmissionDto.toEntity(dto.getTypeEmission()));
    return emission;
  }

}
