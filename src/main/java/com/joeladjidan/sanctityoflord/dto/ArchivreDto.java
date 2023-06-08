package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Archivre;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ArchivreDto {

  private Integer id;
  private Date dateArchivre;
  private EnseignementDto enseignement;
  private EmissionDto emission;
  private AnneeDto annee;
  private MoisDto mois;
  private DonneeDto donnee;

  public static ArchivreDto fromEntity(Archivre archivre) {
    if (archivre == null) {
        return null;
    }

    return ArchivreDto.builder()
      .id(archivre.getId())
      .dateArchivre(archivre.getDateArchivre())
      .mois(MoisDto.fromEntity(archivre.getMois()))
      .annee(AnneeDto.fromEntity(archivre.getAnnee()))
      .emission(EmissionDto.fromEntity(archivre.getEmission()))
      .enseignement(EnseignementDto.fromEntity(archivre.getEnseignement()))
      .donnee(DonneeDto.fromEntity(archivre.getDonnee()))
      .build();
  }

  public static Archivre toEntity(ArchivreDto dto) {
    if (dto == null) {
        return null;
    }
    Archivre archivre = new Archivre();
    archivre.setId(dto.getId());
    archivre.setDateArchivre(dto.getDateArchivre());
    archivre.setMois(MoisDto.toEntity(dto.getMois()));
    archivre.setAnnee(AnneeDto.toEntity(dto.getAnnee()));
    archivre.setEmission(EmissionDto.toEntity(dto.getEmission()));
    archivre.setEnseignement(EnseignementDto.toEntity(dto.getEnseignement()));
    archivre.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
    return archivre;
  }

}
