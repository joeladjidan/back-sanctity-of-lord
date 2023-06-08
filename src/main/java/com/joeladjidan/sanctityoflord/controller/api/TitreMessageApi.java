package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.TitreMessageDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.TITRE_MESSAGE_ENDPOINT;

@Api("titremessage")
public interface TitreMessageApi {

  @PostMapping(TITRE_MESSAGE_ENDPOINT + "/enregistrer")
  TitreMessageDto enregistrer(@RequestBody TitreMessageDto dto);

  @GetMapping(TITRE_MESSAGE_ENDPOINT + "/{id}")
  TitreMessageDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = TITRE_MESSAGE_ENDPOINT + "/tous", produces="application/json")
  List<TitreMessageDto> findAll();

  @DeleteMapping(TITRE_MESSAGE_ENDPOINT + "/supprimer/{id}")
  void delete(@PathVariable("id") Integer id);

}
