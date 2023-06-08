package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalerieService {

  GalerieDto enregistrer(GalerieDto dto);

  GalerieDto findById(Integer id);

  List<GalerieDto> findAll();

  void supprimer(Integer id);

  GalerieDto modifier(Integer id, GalerieDto dto);

  void enregistreImage(MultipartFile file);

}
