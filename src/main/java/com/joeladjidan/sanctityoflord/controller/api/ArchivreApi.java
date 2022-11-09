package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.ARCHIVRE_ENDPOINT;

@Api("archivre")
public interface ArchivreApi {

  @PostMapping(ARCHIVRE_ENDPOINT + "/create")
  ArchivreDto save(@RequestBody ArchivreDto dto);

  @GetMapping(ARCHIVRE_ENDPOINT + "/{idArchivre}")
  ArchivreDto findById(@PathVariable("idArchivre") Integer id);

  @GetMapping(ARCHIVRE_ENDPOINT + "/all")
  List<ArchivreDto> findAll();

  @DeleteMapping(ARCHIVRE_ENDPOINT + "/delete/{idArchivre}")
  void delete(@PathVariable("idArchivre") Integer id);

}
