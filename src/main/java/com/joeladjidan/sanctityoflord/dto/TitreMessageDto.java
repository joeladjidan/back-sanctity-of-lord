package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Enseignement;
import com.joeladjidan.sanctityoflord.model.TitreMessage;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class TitreMessageDto {

  private String intitule;
  private String description;

  public static TitreMessageDto fromEntity(TitreMessage titreMessage) {
    if (titreMessage == null) {
        return null;
    }

    return TitreMessageDto.builder()
        .intitule(titreMessage.getIntitule())
        .description(titreMessage.getDescription())
        .build();
  }

  public static TitreMessage toEntity(TitreMessageDto dto) {
    if (dto == null) {
        return null;
    }
    TitreMessage titreMessage = new TitreMessage();
     titreMessage.setIntitule(dto.getIntitule());
     titreMessage.setDescription(dto.getDescription());
    return titreMessage;
  }

}
