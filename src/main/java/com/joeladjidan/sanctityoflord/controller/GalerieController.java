package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.GalerieApi;
import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import com.joeladjidan.sanctityoflord.services.GalerieService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = { "Gestion des galeries" })
@RestController
@Slf4j
public class GalerieController implements GalerieApi {

  private GalerieService galerieService;

  @Autowired
  public GalerieController(GalerieService galerieService) {
    this.galerieService = galerieService;
  }

  @Override
  public GalerieDto enregistrer(GalerieDto dto) {
    return galerieService.enregistrer(dto);
  }

  @Override
  public GalerieDto findById(Integer id) {
    return galerieService.findById(id);
  }


  @Override
  public List<GalerieDto> findAll() {
    log.info("debut recupere la liste de toute les photos ");
    List<GalerieDto> listGalerie = galerieService.findAll();
    log.info("fin recupere la liste de toute les photos size {} " , listGalerie.size());
    return listGalerie;
  }

  @Override
  public void supprimer(Integer id) {
    galerieService.supprimer(id);
  }

  @Override
  public GalerieDto modifier(Integer id, GalerieDto dto) {
    return galerieService.modifier(id, dto);
  }

  @Override
  public void enregistrerImage(MultipartFile fichier) {
     this.galerieService.enregistreImage(fichier);
  }
}
