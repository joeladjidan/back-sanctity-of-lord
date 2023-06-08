package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.DonneeDto;
import com.joeladjidan.sanctityoflord.dto.EnseignementDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.model.Donnee;
import com.joeladjidan.sanctityoflord.model.Emission;
import com.joeladjidan.sanctityoflord.model.Enseignement;
import com.joeladjidan.sanctityoflord.model.Galerie;
import com.joeladjidan.sanctityoflord.repository.DonneeRepository;
import com.joeladjidan.sanctityoflord.repository.EmissionRepository;
import com.joeladjidan.sanctityoflord.repository.EnseignementRepository;
import com.joeladjidan.sanctityoflord.repository.GalerieRepository;
import com.joeladjidan.sanctityoflord.services.DonneeService;
import com.joeladjidan.sanctityoflord.validator.DonneeValidator;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
public class DonneeServiceImpl implements DonneeService {

    private DonneeRepository donneeRepository;
    private GalerieRepository galerieRepository;
    private EmissionRepository emissionRepository;
    private EnseignementRepository enseignementRepository;

    @Autowired
    public DonneeServiceImpl(DonneeRepository donneeRepository,
                             GalerieRepository galerieRepository,
                             EmissionRepository emissionRepository,
                             EnseignementRepository enseignementRepository)
    {
        this.donneeRepository = donneeRepository;
        this.galerieRepository = galerieRepository;
        this.emissionRepository = emissionRepository;
        this.enseignementRepository = enseignementRepository;
    }

    @Autowired
    private ApplicationContext appContext;

    @Override
    public DonneeDto findByFileName(String fileName) {
        Donnee donnee = donneeRepository.findByFileName(fileName);
        return DonneeDto.fromEntity(donnee);
    }

    @Override
    public DonneeDto enregistrer(DonneeDto dto) {
        List<String> errors = DonneeValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Donnee is not valid {}", dto);
            throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        dto.setDate(new Date());

        return DonneeDto.fromEntity(
                donneeRepository.save(
                        DonneeDto.toEntity(dto)
                )
        );
    }

    @Override
    public DonneeDto findById(Integer id) {
        if (id == null) {
            log.error("Annee ID is null");
            return null;
        }
        return donneeRepository.findById(id)
                .map(DonneeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<DonneeDto> findAll() {
        return donneeRepository.findAll()
                .stream()
                .map(DonneeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null) {
            log.error("Ames ID is null");
            return;
        }

        DonneeDto donneeDto = findById(id);
        if (donneeDto != null) {

            Enseignement enseignement = enseignementRepository.findByDonneeId(id);
            if (enseignement != null) {
                enseignementRepository.delete(enseignement);
            }

            Emission emission = emissionRepository.findByDonneeId(id);
            if (emission != null) {
                emissionRepository.delete(emission);
            }

            Galerie galerie = galerieRepository.findByDonneeId(id);
            if (galerie != null) {
                galerieRepository.delete(galerie);
            }

            donneeRepository.deleteById(id);
        }
    }

    @Override
    public void reportDonnee(Integer id, HttpServletResponse response) {
        try {
            List<DonneeDto> listDonnee = findAll();
            DonneeDto donneeDto = findById(id);
            Enseignement enseignement = this.enseignementRepository.findByDonneeId(id);
            Emission emission = this.emissionRepository.findByDonneeId(id);
            Galerie galerie = this.galerieRepository.findByDonneeId(id);

            Resource resource = appContext.getResource("classpath:/jasperreports/jr-details-donnees.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDonnee);

            Map<String, Object> params = new HashMap<>();
            params.put("url", donneeDto.getUrl());
            params.put("nom", donneeDto.getFileName());
            params.put("format", donneeDto.getFormat());

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String strDate = dateFormat.format(donneeDto.getDate());
            params.put("dateFichier", strDate);

            if (enseignement != null) {
                params.put("titreMessage", enseignement.getTitreMessage().getIntitule());
                params.put("typeEnseignement", enseignement.getTypeEnseignement().getIntitule());
                params.put("typeEmission", enseignement.getTypeEmission().getIntitule());
            }
            if (emission != null) {
                params.put("typeEmission", emission.getTypeEmission().getIntitule());
                params.put("descriptionEmission", emission.getDescription());
                params.put("dateEmission", emission.getDateEmission());
            }
            if (galerie != null) {
               params.put("intituleGalerie", galerie.getIntitule());
            }
            params.put("logo1", "classpath:/jasperreports/logo-sanctity.jpg");
            params.put("logo2", "classpath:/jasperreports/logo-anagkazo.gif");

            generateReportPDF(response, jasperReport, dataSource, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateReportPDF(HttpServletResponse resp, JasperReport jasperReport, JRDataSource dataSource,
                                   Map<String, Object> params) throws Exception {
        byte[] bytes = null;
        bytes = JasperRunManager.runReportToPdf(jasperReport, params, dataSource);
        resp.reset();
        resp.resetBuffer();
        resp.setContentType("application/pdf");
        resp.setContentLength(bytes.length);
        ServletOutputStream ouputStream = resp.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
        ouputStream.close();
    }

    @Override
    public DonneeDto modifier(Integer id, DonneeDto dto) {
        List<String> errors = DonneeValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Donnee is not valid {}", dto);
            throw new InvalidEntityException("Le contact n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        if (id == null) {
            log.error("Donnee ID is null");
            return null;
        }
        DonneeDto dtoUpdate = findById(id);

        if (dtoUpdate != null)
        {
            dtoUpdate.setDate(new Date());
            dtoUpdate.setUrl(dto.getUrl());
            dtoUpdate.setFormat(dto.getFormat());
            dtoUpdate.setFileName(dto.getFileName());
        }
        DonneeDto donneeDto = DonneeDto.fromEntity(
                donneeRepository.save(
                        DonneeDto.toEntity(dtoUpdate)
                )
        );
        if (donneeDto != null) {
            Enseignement enseignement = enseignementRepository.findByDonneeId(dtoUpdate.getId());
            if (enseignement != null) {
                EnseignementDto enseignementDto = EnseignementDto.fromEntity(enseignement);
                enseignementRepository.save(
                        EnseignementDto.toEntity(enseignementDto)
                );
            }
        }
        return donneeDto;
    }

}
