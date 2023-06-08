package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.AmesDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.AmesRepository;
import com.joeladjidan.sanctityoflord.services.AmesService;
import com.joeladjidan.sanctityoflord.validator.AmesValidator;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AmesServiceImpl implements AmesService {

  private AmesRepository amesRepository;

  @Autowired
  public AmesServiceImpl(AmesRepository amesRepository) {
    this.amesRepository = amesRepository;
  }

  @Autowired
  private ApplicationContext appContext;

  @Override
  public AmesDto enregistrer(AmesDto dto) {
    List<String> errors = AmesValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return AmesDto.fromEntity(
            amesRepository.save(
              AmesDto.toEntity(dto)
        )
    );
  }

  @Override
  public AmesDto findById(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return null;
    }
    return amesRepository.findById(id)
        .map(AmesDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune ames avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<AmesDto> findAll() {
    return amesRepository.findAll().stream()
        .map(AmesDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
      amesRepository.deleteById(id);
  }

    @Override
    public void reportListAmes(HttpServletResponse response) {
        try {
            List<AmesDto> listAmes = findAll();
            Resource resource = appContext.getResource("classpath:/jasperreports/jr-liste-des-ames.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listAmes);

            Map<String, Object> params = new HashMap<>();
            params.put("logo1", "classpath:/jasperreports/logo-sanctity.jpg");
            params.put("logo2", "classpath:/jasperreports/logo-anagkazo.gif");

            generateReportPDF(response, jasperReport, dataSource, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reportAmes(Integer id, HttpServletResponse response) {
    try {
        List<AmesDto> listAmes = findAll();
            AmesDto amesDto = findById(id);

            Resource resource = appContext.getResource("classpath:/jasperreports/jr-details-ames.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listAmes);

            Map<String, Object> params = new HashMap<>();
            params.put("nom", amesDto.getNom());
            params.put("email", amesDto.getEmail());
            params.put("photo", amesDto.getPhoto());
            params.put("prenom", amesDto.getPrenom());
            params.put("localisation", amesDto.getLocalisation());
            params.put("telephone", amesDto.getTelephone());
            String pays = amesDto.getPays() != null ? amesDto.getPays().getIntitule() : "";
            String ville = amesDto.getVille() != null ? amesDto.getVille().getIntitule() : "";
            String codePostale = amesDto.getCodePostale() != null ? amesDto.getCodePostale().getCode() : "";
            String civilite = amesDto.getCivilite() != null ? amesDto.getCivilite().getIntitule() : "";
            params.put("pays", pays);
            params.put("ville", ville);
            params.put("codePostale", codePostale);
            params.put("civilite", civilite);
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
}
