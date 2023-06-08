package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.DonneeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.DONNEE_ENDPOINT;

@Api("donnee")
public interface DonneeApi {

  @GetMapping(value = DONNEE_ENDPOINT + "/tous", produces="application/json")
  List<DonneeDto> findAll();

  @PostMapping(DONNEE_ENDPOINT + "/enregistrer")
  DonneeDto enregistrer(@RequestBody DonneeDto dto);

  @GetMapping(value = DONNEE_ENDPOINT + "/{id}", produces="application/json")
  DonneeDto findById(@PathVariable("id") Integer id);

  @DeleteMapping(DONNEE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

  @GetMapping(value = DONNEE_ENDPOINT + "/nomfichier/{fileName}", produces="application/json")
  DonneeDto findByFileName(@PathVariable("fileName") String fileName);

  @PutMapping(DONNEE_ENDPOINT + "/modifier/{id}")
  DonneeDto modifier(@PathVariable("id") Integer id, @RequestBody DonneeDto dto);

  @ApiOperation("Returns pdf report of students enrolled to a course with a id that is passed as a path variable (from ms faculty)")
  @GetMapping(DONNEE_ENDPOINT + "/report/details/{id}")
  void reportDonnee(@PathVariable("id") Integer id, HttpServletResponse response);

}
