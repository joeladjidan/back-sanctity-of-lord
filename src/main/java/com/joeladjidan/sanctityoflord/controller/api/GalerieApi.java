package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.GALERIE_ENDPOINT;

@Api("galerie")
public interface GalerieApi {

  @PostMapping(GALERIE_ENDPOINT + "/enregistrer")
  GalerieDto enregistrer(@RequestBody GalerieDto dto);

  @PostMapping(GALERIE_ENDPOINT + "/image")
  void enregistrerImage (@RequestParam("fichier") MultipartFile fichier);

  @GetMapping(value = GALERIE_ENDPOINT + "/id", produces="application/json")
  GalerieDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = GALERIE_ENDPOINT + "/tous", produces="application/json")
  List<GalerieDto> findAll();

  @DeleteMapping(GALERIE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

  @PutMapping(GALERIE_ENDPOINT + "/modifier/{id}")
  GalerieDto modifier(@PathVariable("id") Integer id, @RequestBody GalerieDto dto);

}
