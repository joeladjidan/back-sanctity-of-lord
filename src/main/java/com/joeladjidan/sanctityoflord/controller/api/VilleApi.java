package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.VilleDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.VILLE_ENDPOINT;


@Api("ville")
public interface VilleApi {

  @PostMapping(VILLE_ENDPOINT + "/enregistrer")
  VilleDto enregistrer(@RequestBody VilleDto dto);

  @GetMapping(VILLE_ENDPOINT + "/{id}")
  VilleDto findById(@PathVariable("id") Integer id);

  @GetMapping(VILLE_ENDPOINT + "/tous")
  List<VilleDto> findAll();

  @DeleteMapping(VILLE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
