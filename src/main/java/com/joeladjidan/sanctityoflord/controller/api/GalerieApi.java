package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.GalerieDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.GALERIE_ENDPOINT;

@Api("galerie")
@CrossOrigin(origins = "http://localhost:4200")
public interface GalerieApi {

  @PostMapping(GALERIE_ENDPOINT + "/create")
  GalerieDto save(@RequestBody GalerieDto dto);

  @GetMapping(GALERIE_ENDPOINT + "/{idGalerie}")
  GalerieDto findById(@PathVariable("idGalerie") Integer id);

  @GetMapping(GALERIE_ENDPOINT + "/all")
  List<GalerieDto> findAll();

  @DeleteMapping(GALERIE_ENDPOINT + "/delete/{idGalerie}")
  void delete(@PathVariable("idGalerie") Integer id);

}
