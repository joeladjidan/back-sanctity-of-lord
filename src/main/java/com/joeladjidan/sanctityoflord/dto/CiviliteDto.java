package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.Civilite;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class CiviliteDto {

  private Integer id;
  private String intitule;


  public static CiviliteDto fromEntity(Civilite civilite) {
    if (civilite == null) {
        return null;
    }

    return CiviliteDto.builder()
        .id(civilite.getId())
        .intitule(civilite.getIntitule())
        .build();
  }

  public static Civilite toEntity(CiviliteDto dto) {
    if (dto == null) {
        return null;
    }
      Civilite civilite = new Civilite();
    civilite.setId(dto.getId());
    civilite.setIntitule(dto.getIntitule());
    return civilite;
  }

}
