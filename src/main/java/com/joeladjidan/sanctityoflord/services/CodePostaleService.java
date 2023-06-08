package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.CodePostaleDto;

import java.util.List;

public interface CodePostaleService {

  CodePostaleDto enregistrer(CodePostaleDto dto);

  CodePostaleDto findById(Integer id);

  List<CodePostaleDto> findAll();

  void supprimer(Integer id);
}
