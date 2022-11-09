package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Emission;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class EmissionDto {

  private String description;
  private Date dateEmission;
  private DonneeDto donnee;
  private TypeEmissionDto typeEmission;

  public static EmissionDto fromEntity(Emission emission) {
    if (emission == null) {
        return null;
    }
    return EmissionDto.builder()
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
    emission.setDescription(dto.getDescription());
    emission.setDateEmission(dto.getDateEmission());
    emission.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
    emission.setTypeEmission(TypeEmissionDto.toEntity(dto.getTypeEmission()));
    return emission;
  }

}
