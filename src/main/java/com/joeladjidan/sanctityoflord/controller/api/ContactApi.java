package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.ContactDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.CONTACT_ENDPOINT;

@Api("contact")
public interface ContactApi {

  @PostMapping(CONTACT_ENDPOINT + "/enregistrer")
  ContactDto enregistrer(@RequestBody ContactDto dto);

  @PutMapping(CONTACT_ENDPOINT + "/modifier/{id}")
  ContactDto modifier(@PathVariable("id") Integer id, @RequestBody ContactDto dto);

  @GetMapping(CONTACT_ENDPOINT + "/{id}")
  ContactDto findById(@PathVariable("id") Integer id);

  @GetMapping(CONTACT_ENDPOINT + "/tous")
  List<ContactDto> findAll();

  @DeleteMapping(CONTACT_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
