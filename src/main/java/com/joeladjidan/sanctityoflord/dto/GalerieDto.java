package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.Galerie;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class GalerieDto {

  private String intitule;
  private DonneeDto donnee;


  public static GalerieDto fromEntity(Galerie galerie) {
    if (galerie == null) {
        return null;
    }

    return GalerieDto.builder()
        .intitule(galerie.getIntitule())
        .donnee(DonneeDto.fromEntity(galerie.getDonnee()))
        .build();
  }

  public static Galerie toEntity(GalerieDto dto) {
    if (dto == null) {
        return null;
    }
    Galerie galerie = new Galerie();
    galerie.setIntitule(dto.getIntitule());
    galerie.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
    return galerie;
  }

}
