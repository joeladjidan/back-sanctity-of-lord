package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Ames;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class AmesDto {

  private Integer id;
  private String nom;
  private String prenom;
  private String email;
  private String photo;
  private String sujet;
  private String telephone;
  private String localisation;
  private VilleDto ville;
  private PaysDto pays;
  private CiviliteDto civilite;
  private CodePostaleDto codePostale;

  public static AmesDto fromEntity(Ames ames) {
    if (ames == null) {
        return null;
    }

    return AmesDto.builder()
        .id(ames.getId())
        .nom(ames.getNom().toUpperCase())
        .prenom(ames.getPrenom().toUpperCase())
        .email(ames.getEmail().toUpperCase())
        .photo(ames.getPhoto())
        .sujet(ames.getSujet())
        .telephone(ames.getTelephone())
        .localisation(ames.getLocalisation())
        .pays(PaysDto.fromEntity(ames.getPays()))
        .civilite(CiviliteDto.fromEntity(ames.getCivilite()))
        .ville(VilleDto.fromEntity(ames.getVille()))
        .codePostale(CodePostaleDto.fromEntity(ames.getCodePostale()))
        .build();
  }

  public static Ames toEntity(AmesDto dto) {
      if (dto == null) {
          return null;
      }
      Ames ames = new Ames();
      ames.setId(dto.getId());
      ames.setNom(dto.getNom().toUpperCase());
      ames.setPrenom(dto.getPrenom().toUpperCase());
      ames.setEmail(dto.getEmail().toUpperCase());
      ames.setSujet(dto.getSujet());
      ames.setTelephone(dto.getTelephone());
      ames.setPhoto(dto.getPhoto());
      ames.setLocalisation(dto.getLocalisation().toUpperCase());
      ames.setVille(VilleDto.toEntity(dto.getVille()));
      ames.setPays(PaysDto.toEntity(dto.getPays()));
      ames.setCivilite(CiviliteDto.toEntity(dto.getCivilite()));
      ames.setCodePostale(CodePostaleDto.toEntity(dto.getCodePostale()));
    return ames;
  }

}
