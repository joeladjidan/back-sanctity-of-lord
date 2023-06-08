package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Annonce;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnnonceDto {

  private String url;
  private String intitule;

  public static AnnonceDto fromEntity(Annonce annonce) {
    if (annonce == null) {
        return null;
    }

    return AnnonceDto.builder()
        .url(annonce.getUrl())
        .intitule(annonce.getIntitule())
        .build();
  }

  public static Annonce toEntity(AnnonceDto annonceDto) {
    if (annonceDto == null) {
        return null;
    }
    Annonce annonce = new Annonce();
    annonce.setUrl(annonceDto.url);
    annonce.setIntitule(annonceDto.intitule);
    return annonce;
  }

}
