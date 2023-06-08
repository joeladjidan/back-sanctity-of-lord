package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Ville;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class VilleDto {

  private int id;
  private String intitule;
  private String description;

  public static VilleDto fromEntity(Ville ville) {
    if (ville == null) {
        return null;
    }

    return VilleDto.builder()
        .id(ville.getId())
        .intitule(ville.getIntitule())
        .description(ville.getDescription())
        .build();
  }

  public static Ville toEntity(VilleDto dto) {
    if (dto == null) {
        return null;
    }
    Ville ville = new Ville();
      ville.setId(dto.getId());
      ville.setIntitule(dto.getIntitule());
      ville.setDescription(dto.getDescription());
    return ville;
  }

}
