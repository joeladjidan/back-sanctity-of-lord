package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.Enseignement;
import com.joeladjidan.sanctityoflord.utils.Constants;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
public class EnseignementDto {

  private Integer id;
  private String description;
  private DonneeDto donnee;
  private boolean isYoutube;
  private TypeEmissionDto typeEmission;
  private TitreMessageDto titreMessage;
  private TypeEnseignementDto typeEnseignement;

  public static EnseignementDto fromEntity(Enseignement enseignement) {
    if (enseignement == null) {
        return null;
    }
    return EnseignementDto.builder()
        .id(enseignement.getId())
        .typeEnseignement(TypeEnseignementDto.fromEntity(enseignement.getTypeEnseignement()))
        .titreMessage(TitreMessageDto.fromEntity(enseignement.getTitreMessage()))
        .typeEmission(TypeEmissionDto.fromEntity(enseignement.getTypeEmission()))
        .donnee(DonneeDto.fromEntity(enseignement.getDonnee()))
        .description(enseignement.getDescription())
        .isYoutube(enseignement.isYoutube())
        .build();
  }

  public static Enseignement toEntity(EnseignementDto dto) {
    if (dto == null) {
        return null;
    }
    Enseignement enseignement = new Enseignement();
      enseignement.setId(dto.getId());
      if (dto.getDonnee() != null) {
          enseignement.setYoutube(false);
        if (dto.getDonnee().getFormat().equalsIgnoreCase(Constants.MP4)) {
            enseignement.setYoutube(true);
        }
      }

      enseignement.setDescription(dto.getDescription());
      enseignement.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
      enseignement.setTypeEmission(TypeEmissionDto.toEntity(dto.getTypeEmission()));
      enseignement.setTitreMessage(TitreMessageDto.toEntity(dto.getTitreMessage()));
      enseignement.setTypeEnseignement(TypeEnseignementDto.toEntity(dto.getTypeEnseignement()));
    return enseignement;
  }

}

