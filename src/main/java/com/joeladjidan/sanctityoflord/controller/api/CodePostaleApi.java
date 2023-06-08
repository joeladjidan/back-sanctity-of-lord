package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.CodePostaleDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.CODE_POSTALE_ENDPOINT;


@Api("code-postale")
public interface CodePostaleApi {

  @PostMapping(CODE_POSTALE_ENDPOINT + "/enregistrer")
  CodePostaleDto enregistrer(@RequestBody CodePostaleDto dto);

  @GetMapping(CODE_POSTALE_ENDPOINT + "/{id}")
  CodePostaleDto findById(@PathVariable("id") Integer id);

  @GetMapping(CODE_POSTALE_ENDPOINT + "/tous")
  List<CodePostaleDto> findAll();

  @DeleteMapping(CODE_POSTALE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
