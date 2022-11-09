package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Ville;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VilleDto {

  private String intitule;
  private String description;

  public static VilleDto fromEntity(Ville ville) {
    if (ville == null) {
        return null;
    }

    return VilleDto.builder()
        .intitule(ville.getIntitule())
        .description(ville.getDescription())
        .build();
  }

  public static Ville toEntity(VilleDto dto) {
    if (dto == null) {
        return null;
    }
    Ville ville = new Ville();
      ville.setIntitule(dto.getIntitule());
      ville.setDescription(dto.getDescription());
    return ville;
  }

}
