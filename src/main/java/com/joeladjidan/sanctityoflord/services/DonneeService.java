package com.joeladjidan.sanctityoflord.services;

import com.joeladjidan.sanctityoflord.dto.DonneeDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface DonneeService {

   DonneeDto findByFileName(String fileName);

   DonneeDto enregistrer(DonneeDto dto);

   DonneeDto modifier(Integer id, DonneeDto dto);

   DonneeDto findById(Integer id);

   List<DonneeDto> findAll();

   void supprimer(Integer id);

   void reportDonnee(Integer id, HttpServletResponse response);
}
