package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.dto.TitreMessageDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ENSEIGNEMENT_ENDPOINT;
import static com.joeladjidan.sanctityoflord.utils.Constants.TITRE_MESSAGE_ENDPOINT;

@Api("titremessage")
public interface TitreMessageApi {

  @PostMapping(TITRE_MESSAGE_ENDPOINT + "/create")
  TitreMessageDto save(@RequestBody TitreMessageDto dto);

  @GetMapping(TITRE_MESSAGE_ENDPOINT + "/{idTitreMessage}")
  TitreMessageDto findById(@PathVariable("idTitreMessage") Integer id);

  @GetMapping(TITRE_MESSAGE_ENDPOINT + "/all")
  List<TitreMessageDto> findAll();

  @DeleteMapping(TITRE_MESSAGE_ENDPOINT + "/delete/{idTitreMessage}")
  void delete(@PathVariable("idTitreMessage") Integer id);

}
