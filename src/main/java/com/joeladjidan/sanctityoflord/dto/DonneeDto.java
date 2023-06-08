package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.Donnee;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class DonneeDto {

  private Integer id;
  private Date date;
  private String fileName;
  private String url;
  private String format;

  public static DonneeDto fromEntity(Donnee donnee) {
    if (donnee == null) {
        return null;
    }
    return DonneeDto.builder()
        .id(donnee.getId())
        .url(donnee.getUrl())
        .date(donnee.getDate())
        .format(donnee.getFormat())
        .fileName(donnee.getFileName())
        .build();
  }

  public static Donnee toEntity(DonneeDto dto) {
    if (dto == null) {
        return null;
    }
    Donnee donnee = new Donnee();
    donnee.setId(dto.getId());
    donnee.setUrl(dto.getUrl());
    donnee.setDate(dto.getDate());
    donnee.setFormat(dto.getFormat());
    donnee.setFileName(dto.getFileName());
    return donnee;
  }

}
