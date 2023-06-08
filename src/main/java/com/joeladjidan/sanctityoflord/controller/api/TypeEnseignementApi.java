package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.TYPE_ENSEIGNEMENT_ENDPOINT;

@Api("type-enseignement")
public interface TypeEnseignementApi {

  @PostMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/enregistrer")
  TypeEnseignementDto save(@RequestBody TypeEnseignementDto dto);

  @GetMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/{id}")
  TypeEnseignementDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = TYPE_ENSEIGNEMENT_ENDPOINT + "/tous", produces="application/json")
  List<TypeEnseignementDto> findAll();

  @DeleteMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/supprimer/{id}")
  void delete(@PathVariable("id") Integer id);

}
