package com.joeladjidan.sanctityoflord.controller.api;

import io.swagger.annotations.Api;
import static com.joeladjidan.sanctityoflord.utils.Constants.AUTHENTICATION_ENDPOINT;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.joeladjidan.sanctityoflord.dto.auth.AuthenticationRequest;
import com.joeladjidan.sanctityoflord.dto.auth.AuthenticationResponse;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api("authentication")
@CrossOrigin(origins = "http://localhost:4200")
public interface AuthenticationApi {

  @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
  ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception;

}
