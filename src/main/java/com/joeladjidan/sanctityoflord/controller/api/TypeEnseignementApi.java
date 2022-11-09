package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.TypeEnseignementDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.joeladjidan.sanctityoflord.utils.Constants.TYPE_ENSEIGNEMENT_ENDPOINT;

@Api("type-enseignement")
public interface TypeEnseignementApi {

  @PostMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/create")
  TypeEnseignementDto save(@RequestBody TypeEnseignementDto dto);

  @GetMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/{idTypeEnseignement}")
  TypeEnseignementDto findById(@PathVariable("idTypeEnseignement") Integer id);

  @GetMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/all")
  List<TypeEnseignementDto> findAll();

  @DeleteMapping(TYPE_ENSEIGNEMENT_ENDPOINT + "/delete/{idTypeEnseignement}")
  void delete(@PathVariable("idTypeEnseignement") Integer id);

}
