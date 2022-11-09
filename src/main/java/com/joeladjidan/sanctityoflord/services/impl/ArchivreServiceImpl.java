package com.joeladjidan.sanctityoflord.services.impl;

import com.joeladjidan.sanctityoflord.dto.ArchivreDto;
import com.joeladjidan.sanctityoflord.dto.EmissionDto;
import com.joeladjidan.sanctityoflord.exception.EntityNotFoundException;
import com.joeladjidan.sanctityoflord.exception.ErrorCodes;
import com.joeladjidan.sanctityoflord.exception.InvalidEntityException;
import com.joeladjidan.sanctityoflord.repository.ArchivreRepository;
import com.joeladjidan.sanctityoflord.repository.EmissionRepository;
import com.joeladjidan.sanctityoflord.services.ArchivreService;
import com.joeladjidan.sanctityoflord.services.EmissionService;
import com.joeladjidan.sanctityoflord.validator.ArchivreValidator;
import com.joeladjidan.sanctityoflord.validator.EmissionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ArchivreServiceImpl implements ArchivreService {

  private ArchivreRepository archivreRepository;

  @Autowired
  public ArchivreServiceImpl(ArchivreRepository archivreRepository) {
    this.archivreRepository = archivreRepository;
  }

  @Override
  public ArchivreDto save(ArchivreDto dto) {
    List<String> errors = ArchivreValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Enseignement is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return ArchivreDto.fromEntity(
            archivreRepository.save(
                    ArchivreDto.toEntity(dto)
        )
    );
  }

  @Override
  public ArchivreDto findById(Integer id) {
    if (id == null) {
      log.error("Emission ID is null");
      return null;
    }
    return archivreRepository.findById(id)
        .map(ArchivreDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune emission avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
  }

  @Override
  public List<ArchivreDto> findAll() {
    return archivreRepository.findAll().stream()
        .map(ArchivreDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Emission ID is null");
      return;
    }
    archivreRepository.deleteById(id);
  }
}
