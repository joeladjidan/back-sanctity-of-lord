package com.joeladjidan.sanctityoflord.controller.api;


import com.joeladjidan.sanctityoflord.dto.ChangerMotDePasseUtilisateurDto;
import com.joeladjidan.sanctityoflord.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("utilisateurs")
public interface UtilisateurApi {

  @PostMapping(UTILISATEUR_ENDPOINT + "/enregistrer")
  UtilisateurDto save(@RequestBody UtilisateurDto dto);

  @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
  UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

  @GetMapping(UTILISATEUR_ENDPOINT + "/{id}")
  UtilisateurDto findById(@PathVariable("id") Integer id);

  @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
  UtilisateurDto findByEmail(@PathVariable("email") String email);

  @GetMapping(value = UTILISATEUR_ENDPOINT + "/tous", produces="application/json")
  List<UtilisateurDto> findAll();

  @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{id}")
  void delete(@PathVariable("id") Integer id);

}
