package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ENSEIGNEMENT_ENDPOINT;

@Api("enseignement")
public interface EnseignementApi {

  @PostMapping(ENSEIGNEMENT_ENDPOINT + "/create")
  EnseignementDto save(@RequestBody EnseignementDto dto);

  @GetMapping(ENSEIGNEMENT_ENDPOINT + "/{idEnseignement}")
  EnseignementDto findById(@PathVariable("idEnseignement") Integer id);

  @GetMapping(ENSEIGNEMENT_ENDPOINT + "/all")
  List<EnseignementDto> findAll();

  @DeleteMapping(ENSEIGNEMENT_ENDPOINT + "/delete/{idEnseignement}")
  void delete(@PathVariable("idEnseignement") Integer id);

}
