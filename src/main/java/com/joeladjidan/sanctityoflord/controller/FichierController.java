package com.joeladjidan.sanctityoflord.controller;

import com.joeladjidan.sanctityoflord.controller.api.FichierApi;
import com.joeladjidan.sanctityoflord.dto.FichierDto;
import com.joeladjidan.sanctityoflord.model.Fichier;
import com.joeladjidan.sanctityoflord.utils.FichierService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api(tags = { "Gestion des medias" })
@RestController
@Slf4j
public class FichierController implements FichierApi {

    private final FichierService fichierService;

    @Autowired
    public FichierController(FichierService fichierService) {
        this.fichierService = fichierService;
    }

    @Override
    public FichierDto enregistrerFichier(@RequestParam("fichier") MultipartFile fichier,
                                         @RequestParam("typeFichier") String typeFichier) throws FileUploadException {
        String fileName = fichierService.enregistrerFichiers(fichier, typeFichier);
        Fichier fichierDto = new Fichier();
        fichierDto.setNom(fileName);
        return FichierDto.fromEntity(fichierDto);
    }

    @Override
    public List<String> recupererFichiers(String typeFichier) throws IOException {
        return fichierService.getFiles(typeFichier);
    }


    @Override
    public void supprimer(String nom, String typeFichier) {
        fichierService.supprimer(nom, typeFichier);
    }

}
