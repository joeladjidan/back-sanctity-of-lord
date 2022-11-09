package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Archivre;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class ArchivreDto {

  private Date dateArchivre;
  private EnseignementDto enseignement;
  private EmissionDto emission;

  public static ArchivreDto fromEntity(Archivre archivre) {
    if (archivre == null) {
        return null;
    }

    return ArchivreDto.builder()
      .enseignement(EnseignementDto.fromEntity(archivre.getEnseignement()))
      .emission(EmissionDto.fromEntity(archivre.getEmission()))
       .dateArchivre(archivre.getDateArchivre())
      .build();
  }

  public static Archivre toEntity(ArchivreDto dto) {
    if (dto == null) {
        return null;
    }
    Archivre archivre = new Archivre();
    archivre.setDateArchivre(dto.getDateArchivre());
    archivre.setEmission(EmissionDto.toEntity(dto.getEmission()));
    archivre.setEnseignement(EnseignementDto.toEntity(dto.getEnseignement()));
    return archivre;
  }

}
