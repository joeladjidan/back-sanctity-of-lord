package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Annee;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class AnneeDto {

  private Integer id;
  private String intitule;

  public static AnneeDto fromEntity(Annee annee) {
    if (annee == null) {
        return null;
    }

    return AnneeDto.builder()
        .id(annee.getId())
        .intitule(annee.getIntitule())
        .build();
  }

  public static Annee toEntity(AnneeDto dto) {
    if (dto == null) {
        return null;
    }
      Annee annee = new Annee();
      annee.setId(dto.getId());
      annee.setIntitule(dto.getIntitule());
    return annee;
  }

}
