package com.joeladjidan.sanctityoflord.services;

import java.util.List;

import com.joeladjidan.sanctityoflord.dto.ChangerMotDePasseUtilisateurDto;
import com.joeladjidan.sanctityoflord.dto.UtilisateurDto;

public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  List<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
