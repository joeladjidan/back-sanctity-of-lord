package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.EMISSION_ENDPOINT;

@Api("emission")
public interface EmissionApi {

  @PostMapping(EMISSION_ENDPOINT + "/create")
  EmissionDto save(@RequestBody EmissionDto dto);

  @GetMapping(EMISSION_ENDPOINT + "/{idEmission}")
  EmissionDto findById(@PathVariable("idEmission") Integer id);

  @GetMapping(EMISSION_ENDPOINT + "/all")
  List<EmissionDto> findAll();

  @DeleteMapping(EMISSION_ENDPOINT + "/delete/{idEmission}")
  void delete(@PathVariable("idEmission") Integer id);

}
