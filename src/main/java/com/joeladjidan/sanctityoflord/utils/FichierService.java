package com.joeladjidan.sanctityoflord.utils;

import com.joeladjidan.sanctityoflord.repository.ParametreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class FichierService {

	private String uploadPath;

	@Autowired
    ParametreRepository parametreRepository;

	public void save(MultipartFile file) {
		try {
			Path root = Paths.get(uploadPath);
			Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	public Resource load(String filename) {
		try {
			Path file = Paths.get(uploadPath)
					.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(Paths.get(uploadPath)
				.toFile());
	}

	public List<Path> loadAll() {
		try {
			Path root = Paths.get(uploadPath);
			if (Files.exists(root)) {
				return Files.walk(root, 1)
						.filter(path -> !path.equals(root))
						.collect(Collectors.toList());
			}

			return Collections.emptyList();
		} catch (IOException e) {
			throw new RuntimeException("Could not list the files!");
		}
	}
}
