package com.joeladjidan.sanctityoflord.utils;

import com.joeladjidan.sanctityoflord.dto.TypeFichierEnum;
import com.joeladjidan.sanctityoflord.repository.ParametreRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

// javaninja.io/angular-9-spirng-boot-rest-api-file-upload-with-progress-bar

@Service
@Slf4j
public class FichierService {

	@Autowired
    ParametreRepository parametreRepository;

//	private String cheminFichierEmission = "F:/anakagzo/audio";
//	private String cheminFichierGalerie = "F:/anakagzo/galerie";
    private String cheminFichierEmission = "C:/wamp64/www/anagkazo/audio";
	private String cheminFichierGalerie = "C:/wamp64/www/anagkazo/galerie";

	public String enregistrerFichiers(MultipartFile file, String typeFichier) throws FileUploadException {
        log.info("Debut de l'insertion des fichiers dans le repertoire {} , {} " + typeFichier , file);
	    String nomFichier = StringUtils.cleanPath(file.getOriginalFilename());
        Path fileStrorageLocation = null;
        try {
            Files.createDirectories(Paths.get(cheminFichierEmission));
            Files.createDirectories(Paths.get(cheminFichierGalerie));

          if ( Integer.parseInt(typeFichier) == TypeFichierEnum.EMISSION.getValeur()) {
              log.info("Debut de l'insertion des fichiers dans le repertoire {} " + TypeFichierEnum.EMISSION.name());
              fileStrorageLocation = Paths.get(cheminFichierEmission);
           } else if(Integer.parseInt(typeFichier) == TypeFichierEnum.GALERIE.getValeur()){
              log.info("Debut de l'insertion des fichiers dans le repertoire {} " + TypeFichierEnum.GALERIE.name());
              fileStrorageLocation = Paths.get(cheminFichierGalerie);
           }

            Path targetLocation = fileStrorageLocation.resolve(nomFichier);
            if (targetLocation.toFile()
                    .exists()) {
                log.error("Le fichier " + file.getOriginalFilename() + " existe deja.");
                return ("Le fichier " + file.getOriginalFilename() + " existe deja.");
            }
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Could not store the file. Error: " + e.getMessage());
            throw new FileUploadException("Could not store the file. Error: " + e.getMessage());
        }
        log.info("Fin de l'insertion des fichiers dans le repertoire {} , {} " + typeFichier , file);
        return nomFichier;
    }

	public List<String> getFiles(String typeFichier) throws IOException {
        log.info("Debut de recuperation de fichier selon le repertoire {} " + typeFichier);
        Path fileStrorageLocation = null;

        if ( Integer.parseInt(typeFichier) == TypeFichierEnum.EMISSION.getValeur()) {
            fileStrorageLocation = Paths.get(cheminFichierEmission);
        } else if(Integer.parseInt(typeFichier) == TypeFichierEnum.GALERIE.getValeur()){
            fileStrorageLocation = Paths.get(cheminFichierGalerie);
        }

        List<String> listFichier = Files.walk(fileStrorageLocation)
                .filter(Files::isRegularFile)
                .map(file -> file.getFileName().toString())
                .collect(Collectors.toList());

        log.info("Fin de recuperation de fichier selon le repertoire {} " + typeFichier);
        return listFichier;

    }

    public void supprimer(String nom, String typeFichier) {
        log.info("Debut de la suppression de fichier {} " + nom);
        if (nom == null) {
            log.error("nom est null");
            return;
        }
        Path fileStrorageLocation = null;
        FileSystem fs = FileSystems.getDefault();
        try {
            if ( Integer.parseInt(typeFichier) == TypeFichierEnum.EMISSION.getValeur()) {
                fileStrorageLocation = Paths.get(cheminFichierEmission + fs.getSeparator() + nom);
            } else if(Integer.parseInt(typeFichier) == TypeFichierEnum.GALERIE.getValeur()){
                fileStrorageLocation = Paths.get(cheminFichierGalerie + fs.getSeparator() + nom);
            }
            Files.deleteIfExists(fileStrorageLocation);
        } catch (NoSuchFileException x) {
            System.err.format("%s:" + " chemin introuvable %n", fileStrorageLocation);
            log.error("Le chemin du fichier {} " + nom + " n'est pas correcte {} " + fileStrorageLocation);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s n'est pas vide %n", fileStrorageLocation);
            log.error("Le repertoire {} " +fileStrorageLocation + " est vide " + x);
        } catch (IOException x) {
            // problèmes de permission
            System.err.println(x);
            log.error("La permission n'est pas accordé pour supprimer le fichier " +x);
        }
        log.info("Fin de la suppression de fichier {} " + nom + " dans le repertoire {} " + fileStrorageLocation);
    }



}
