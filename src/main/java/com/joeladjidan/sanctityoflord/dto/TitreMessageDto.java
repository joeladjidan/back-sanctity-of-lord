package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.TitreMessage;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class TitreMessageDto {

  private int id;
  private String intitule;
  private String description;

  public static TitreMessageDto fromEntity(TitreMessage titreMessage) {
    if (titreMessage == null) {
        return null;
    }

    return TitreMessageDto.builder()
        .id(titreMessage.getId())
        .intitule(titreMessage.getIntitule())
        .description(titreMessage.getDescription())
        .build();
  }

  public static TitreMessage toEntity(TitreMessageDto dto) {
    if (dto == null) {
        return null;
    }
    TitreMessage titreMessage = new TitreMessage();
     titreMessage.setId(dto.getId());
     titreMessage.setIntitule(dto.getIntitule());
     titreMessage.setDescription(dto.getDescription());
    return titreMessage;
  }

}
