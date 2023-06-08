package com.joeladjidan.sanctityoflord.controller.api;

import com.joeladjidan.sanctityoflord.dto.FichierDto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.joeladjidan.sanctityoflord.utils.Constants.FICHIER_ENDPOINT;

@Api("fichier")
public interface FichierApi {

    @PostMapping(value = FICHIER_ENDPOINT + "/enregistrer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    FichierDto enregistrerFichier(@RequestParam("fichier") MultipartFile fichier,
                                  @RequestParam("typeFichier") String typeFichier) throws IOException;

    @GetMapping(value = FICHIER_ENDPOINT + "/listFichiers/{typeFichier}")
    @ResponseStatus(HttpStatus.OK)
    List<String> recupererFichiers(@PathVariable("typeFichier") String typeFichier) throws IOException;

    @DeleteMapping(value = FICHIER_ENDPOINT + "/supprimer/{nom}/{typeFichier}")
    void supprimer(@PathVariable("nom") String nom,
                   @PathVariable("typeFichier") String typeFichier);
}
