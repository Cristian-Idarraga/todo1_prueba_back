package com.todo1.prueba_tecnica.controller;

import com.todo1.prueba_tecnica.dto.AuthenticationRequest;
import com.todo1.prueba_tecnica.dto.AuthenticationResponse;
import com.todo1.prueba_tecnica.security.JWTUtil;
import com.todo1.prueba_tecnica.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final JWTUtil jwtUtil;
  private final SecurityUtil securityUtil;

  public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
      JWTUtil jwtUtil, SecurityUtil securityUtil) {
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
    this.securityUtil = securityUtil;
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
    try {
      request.setPassword(securityUtil.encriptar(request.getPassword()));
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
      UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
      String jwt = jwtUtil.gnerateToken(userDetails);
      return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }
}
