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

  @GetMapping(ARCHIVRE_ENDPOINT + "/{id}")
  ArchivreDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = ARCHIVRE_ENDPOINT + "/tous", produces="application/json")
  List<ArchivreDto> findAll();

  @GetMapping(ARCHIVRE_ENDPOINT + "/search/{mois}/{annee}")
  List<ArchivreDto> findByMoisAndAnnee(
          @PathVariable("mois") String mois ,
          @PathVariable("annee") String annee);

  @DeleteMapping(ARCHIVRE_ENDPOINT + "/delete/{id}")
  void delete(@PathVariable("id") Integer id);

}
