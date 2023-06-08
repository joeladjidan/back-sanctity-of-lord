package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.AmesDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface AmesService {

  AmesDto enregistrer(AmesDto dto);

  AmesDto findById(Integer id);

  List<AmesDto> findAll();

  void supprimer(Integer id);

  void reportListAmes(HttpServletResponse response);

  void reportAmes(Integer id, HttpServletResponse response);

}
