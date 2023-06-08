package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.EMISSION_ENDPOINT;

@Api("emission")
public interface EmissionApi {

  @PostMapping(EMISSION_ENDPOINT + "/enregistrer")
  EmissionDto save(@RequestBody EmissionDto dto);

  @GetMapping(EMISSION_ENDPOINT + "/{id}")
  EmissionDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = EMISSION_ENDPOINT + "/tous", produces="application/json")
  List<EmissionDto> findAll();

  @DeleteMapping(EMISSION_ENDPOINT + "/supprimer/{id}")
  void delete(@PathVariable("id") Integer id);

}
