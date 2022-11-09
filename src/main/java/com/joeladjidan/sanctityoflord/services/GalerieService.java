package com.joeladjidan.sanctityoflord.services;


import com.joeladjidan.sanctityoflord.dto.GalerieDto;

import java.util.List;

public interface GalerieService {

  GalerieDto save(GalerieDto dto);

  GalerieDto findById(Integer id);

  List<GalerieDto> findAll();

  void delete(Integer id);
}
