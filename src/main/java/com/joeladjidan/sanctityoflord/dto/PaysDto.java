package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Pays;
import com.joeladjidan.sanctityoflord.model.TitreMessage;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaysDto {

  private String intitule;
  private String description;

  public static PaysDto fromEntity(Pays pays) {
    if (pays == null) {
        return null;
    }

    return PaysDto.builder()
        .intitule(pays.getIntitule())
        .description(pays.getDescription())
        .build();
  }

  public static Pays toEntity(PaysDto dto) {
    if (dto == null) {
        return null;
    }
     Pays pays = new Pays();
      pays.setIntitule(dto.getIntitule());
      pays.setDescription(dto.getDescription());
    return pays;
  }

}
