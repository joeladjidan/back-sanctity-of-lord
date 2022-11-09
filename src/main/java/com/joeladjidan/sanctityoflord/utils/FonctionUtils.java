package com.joeladjidan.sanctityoflord.utils;

import com.joeladjidan.sanctityoflord.model.auth.ExtendedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class FonctionUtils {
	public void creerRepertoire (String repertoire) {
		try {
			Files.createDirectories(Paths.get(repertoire));
		} catch (
				IOException e) {
			throw new RuntimeException("Could not create upload folder ! " + Paths.get(repertoire));
		}
	}
}
