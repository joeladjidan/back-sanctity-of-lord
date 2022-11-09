package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Adresse;
import com.joeladjidan.sanctityoflord.model.CodePostale;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {

  private String adresse1;

  private String adresse2;

  private CodePostaleDto codePostale;

  private VilleDto ville;

  private PaysDto pays;

  public static AdresseDto fromEntity(Adresse adresse) {
    if (adresse == null) {
        return null;
    }

    return AdresseDto.builder()
        .adresse1(adresse.getAdresse1())
        .adresse2(adresse.getAdresse2())
        .codePostale(CodePostaleDto.fromEntity(adresse.getCodePostale()))
        .ville(VilleDto.fromEntity(adresse.getVille()))
        .pays(PaysDto.fromEntity(adresse.getPays()))
        .build();
  }

  public static Adresse toEntity(AdresseDto adresseDto) {
    if (adresseDto == null) {
      return null;
    }
    Adresse adresse = new Adresse();
    adresse.setAdresse1(adresseDto.getAdresse1());
    adresse.setAdresse2(adresseDto.getAdresse2());
    adresse.setCodePostale(CodePostaleDto.toEntity(adresseDto.getCodePostale()));
    adresse.setPays(PaysDto.toEntity(adresseDto.getPays()));
    adresse.setVille(VilleDto.toEntity(adresseDto.getVille()));
    return adresse;
  }

}
