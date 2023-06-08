package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ENSEIGNEMENT_ENDPOINT;

@Api("enseignement")
public interface EnseignementApi {

  @PostMapping(ENSEIGNEMENT_ENDPOINT + "/enregistrer")
  EnseignementDto enregistrer(@RequestBody EnseignementDto dto);

  @GetMapping(ENSEIGNEMENT_ENDPOINT + "/{id}")
  EnseignementDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = ENSEIGNEMENT_ENDPOINT + "/tous", produces="application/json")
  List<EnseignementDto> findAll();

  @GetMapping(ENSEIGNEMENT_ENDPOINT + "/search/{titreMessage}/{typeEnregistrement}")
  List<EnseignementDto> findByTitreMessageAndTypeEnseignement(
          @PathVariable("titreMessage") String titreMessage ,
          @PathVariable("typeEnregistrement") String typeEnregistrement);

  @DeleteMapping(ENSEIGNEMENT_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
