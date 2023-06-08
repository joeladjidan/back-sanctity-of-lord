package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Fichier;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class FichierDto {

  private Integer id;
  private String nom;

  public static FichierDto fromEntity(Fichier fichier) {
    if (fichier == null) {
        return null;
    }

    return FichierDto.builder()
        .id(fichier.getId())
        .nom(fichier.getNom())
        .build();
  }

  public static Fichier toEntity(FichierDto dto) {
    if (dto == null) {
        return null;
    }
      Fichier fichier = new Fichier();
      fichier.setId(dto.getId());
      fichier.setNom(dto.getNom());
    return fichier;
  }

}
