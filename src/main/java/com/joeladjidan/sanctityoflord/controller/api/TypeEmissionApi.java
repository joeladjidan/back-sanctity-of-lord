package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.TypeEmissionDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.TYPE_EMISSION_ENDPOINT;

@Api("type-enseignement")
public interface TypeEmissionApi {

  @PostMapping(TYPE_EMISSION_ENDPOINT + "/create")
  TypeEmissionDto save(@RequestBody TypeEmissionDto dto);

  @GetMapping(TYPE_EMISSION_ENDPOINT + "/{idTypeEmission}")
  TypeEmissionDto findById(@PathVariable("idTypeEmission") Integer id);

  @GetMapping(TYPE_EMISSION_ENDPOINT + "/all")
  List<TypeEmissionDto> findAll();

  @DeleteMapping(TYPE_EMISSION_ENDPOINT + "/delete/{idTypeEmission}")
  void delete(@PathVariable("idTypeEmission") Integer id);

}
