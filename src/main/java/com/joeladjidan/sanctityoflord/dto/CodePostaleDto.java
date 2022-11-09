package com.joeladjidan.sanctityoflord.dto;

import com.joeladjidan.sanctityoflord.model.CodePostale;
import com.joeladjidan.sanctityoflord.model.Pays;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodePostaleDto {

  private String code;
  private String description;

  public static CodePostaleDto fromEntity(CodePostale codePostale) {
    if (codePostale == null) {
        return null;
    }

    return CodePostaleDto.builder()
        .code(codePostale.getCode())
        .description(codePostale.getDescription())
        .build();
  }

  public static CodePostale toEntity(CodePostaleDto dto) {
    if (dto == null) {
        return null;
    }
      CodePostale codePostale = new CodePostale();
      codePostale.setCode(dto.getCode());
      codePostale.setDescription(dto.getDescription());
    return codePostale;
  }

}
