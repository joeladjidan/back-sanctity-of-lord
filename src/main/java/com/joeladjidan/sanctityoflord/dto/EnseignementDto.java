package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EnseignementDto {

  private String description;
  private DonneeDto donnee;
  private TypeEmissionDto typeEmission;
  private TitreMessageDto titreMessage;
  private TypeEnseignementDto typeEnseignement;

  public static EnseignementDto fromEntity(Enseignement enseignement) {
    if (enseignement == null) {
        return null;
    }
    return EnseignementDto.builder()
        .typeEnseignement(TypeEnseignementDto.fromEntity(enseignement.getTypeEnseignement()))
        .titreMessage(TitreMessageDto.fromEntity(enseignement.getTitreMessage()))
        .donnee(DonneeDto.fromEntity(enseignement.getDonnee()))
        .description(enseignement.getDescription())
        .build();
  }

  public static Enseignement toEntity(EnseignementDto dto) {
    if (dto == null) {
        return null;
    }
    Enseignement enseignement = new Enseignement();
      enseignement.setDescription(dto.getDescription());
      enseignement.setDonnee(DonneeDto.toEntity(dto.getDonnee()));
      enseignement.setTitreMessage(TitreMessageDto.toEntity(dto.getTitreMessage()));
      enseignement.setTypeEnseignement(TypeEnseignementDto.toEntity(dto.getTypeEnseignement()));
    return enseignement;
  }

}

