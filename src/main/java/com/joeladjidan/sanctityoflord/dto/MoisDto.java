package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Mois;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class MoisDto {

  private Integer id;
  private String intitule;

  public static MoisDto fromEntity(Mois mois) {
    if (mois == null) {
        return null;
    }

    return MoisDto.builder()
        .id(mois.getId())
        .intitule(mois.getIntitule())
        .build();
  }

  public static Mois toEntity(MoisDto dto) {
    if (dto == null) {
        return null;
    }
      Mois mois = new Mois();
      mois.setId(dto.getId());
      mois.setIntitule(dto.getIntitule());
    return mois;
  }

}
