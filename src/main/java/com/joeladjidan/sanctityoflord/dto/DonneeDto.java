package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Donnee;
import com.joeladjidan.sanctityoflord.model.Emission;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DonneeDto {

  private Date date;
  private String fileName;
  private String url;
  private Long size;

  public static DonneeDto fromEntity(Donnee donnee) {
    if (donnee == null) {
        return null;
    }
    return DonneeDto.builder()
        .url(donnee.getUrl())
        .date(donnee.getDate())
        .size(donnee.getSize())
        .fileName(donnee.getFileName())
        .build();
  }

  public static Donnee toEntity(DonneeDto dto) {
    if (dto == null) {
        return null;
    }
    Donnee donnee = new Donnee();
    donnee.setUrl(dto.getUrl());
    donnee.setSize(dto.getSize());
    donnee.setDate(dto.getDate());
    donnee.setFileName(dto.getFileName());
    return donnee;
  }

}
