package com.joeladjidan.sanctityoflord.dto;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.joeladjidan.sanctityoflord.model.CodePostale;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized //missing
@JsonPOJOBuilder
public class CodePostaleDto {

  private int id;
  private String code;
  private String description;

  public static CodePostaleDto fromEntity(CodePostale codePostale) {
    if (codePostale == null) {
        return null;
    }

    return CodePostaleDto.builder()
        .id(codePostale.getId())
        .code(codePostale.getCode())
        .description(codePostale.getDescription())
        .build();
  }

  public static CodePostale toEntity(CodePostaleDto dto) {
    if (dto == null) {
        return null;
    }
      CodePostale codePostale = new CodePostale();
      codePostale.setId(dto.getId());
      codePostale.setCode(dto.getCode());
      codePostale.setDescription(dto.getDescription());
    return codePostale;
  }

}
