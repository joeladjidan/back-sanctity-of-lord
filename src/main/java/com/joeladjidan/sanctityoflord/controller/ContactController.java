package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.ContactApi;
import com.joeladjidan.sanctityoflord.dto.ContactDto;
import com.joeladjidan.sanctityoflord.services.ContactService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = { "Gestion des personnes à contacter" })
@RestController
@Slf4j
public class ContactController implements ContactApi {

  private ContactService contactService;

  @Autowired
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  @Override
  public ContactDto enregistrer(ContactDto dto) {
    log.info("debut::enregistrer dto {}", dto);
    ContactDto contactDto = contactService.enregistrer(dto);
    log.info("fin::enregistrer dto{}", dto);
    return contactDto;
  }

  @Override
  public ContactDto modifier(Integer id, ContactDto dto) {
      log.info("debut::modifier id , dto  {} {} ", id, dto);
      ContactDto contactDto = contactService.modifier(id, dto);
      return contactDto;
  }

  @Override
  public ContactDto findById(Integer id) {
    return contactService.findById(id);
  }

  @Override
  public List<ContactDto> findAll() {
    return contactService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    contactService.supprimer(id);
  }
}
