package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.AnnonceDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ANNONCE_ENDPOINT;

@Api("annonce")
public interface AnnonceApi {

  @PostMapping(ANNONCE_ENDPOINT + "/enregistrer")
  AnnonceDto enregistrer(@RequestBody AnnonceDto dto);

  @GetMapping(ANNONCE_ENDPOINT + "/{id}")
  AnnonceDto findById(@PathVariable("id") Integer id);

  @GetMapping(ANNONCE_ENDPOINT + "/tous")
  List<AnnonceDto> findAll();

  @DeleteMapping(ANNONCE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
