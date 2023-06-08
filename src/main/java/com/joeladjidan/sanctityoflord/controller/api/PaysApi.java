package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.PaysDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.PAYS_ENDPOINT;

@Api("pays")
public interface PaysApi {

  @PostMapping(PAYS_ENDPOINT + "/enregistrer")
  PaysDto enregistrer(@RequestBody PaysDto dto);

  @GetMapping(PAYS_ENDPOINT + "/{id}")
  PaysDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = PAYS_ENDPOINT + "/tous", produces="application/json")
  List<PaysDto> findAll();

  @DeleteMapping(PAYS_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
