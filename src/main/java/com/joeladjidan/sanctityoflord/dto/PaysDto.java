package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Pays;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class PaysDto {

  private int id;
  private String intitule;
  private String description;

  public static PaysDto fromEntity(Pays pays) {
    if (pays == null) {
        return null;
    }

    return PaysDto.builder()
        .id(pays.getId())
        .intitule(pays.getIntitule())
        .description(pays.getDescription())
        .build();
  }

  public static Pays toEntity(PaysDto dto) {
    if (dto == null) {
        return null;
    }
    Pays pays = new Pays();
    pays.setId(dto.getId());
    pays.setIntitule(dto.getIntitule());
    pays.setDescription(dto.getDescription());
    return pays;
  }

}
