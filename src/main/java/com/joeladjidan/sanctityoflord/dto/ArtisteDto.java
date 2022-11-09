package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Artiste;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class ArtisteDto {

  private String nom;
  private String prenom;
  private String email;
  private Date dateDeNaissance;
  private String photo;
  private AdresseDto adresse;

  public static ArtisteDto fromEntity(Artiste artiste) {
    if (artiste == null) {
        return null;
    }

    return ArtisteDto.builder()
        .nom(artiste.getNom())
        .prenom(artiste.getPrenom())
        .email(artiste.getEmail())
        .photo(artiste.getPhoto())
        .dateDeNaissance(artiste.getDateDeNaissance())
        .build();
  }

  public static Artiste toEntity(ArtisteDto dto) {
    if (dto == null) {
        return null;
    }
    Artiste artiste = new Artiste();
    artiste.setNom(dto.getNom());
    artiste.setPrenom(dto.getPrenom());
    artiste.setEmail(dto.getEmail());
    artiste.setDateDeNaissance(dto.getDateDeNaissance());
    artiste.setPhoto(dto.getPhoto());
    return artiste;
  }

}
