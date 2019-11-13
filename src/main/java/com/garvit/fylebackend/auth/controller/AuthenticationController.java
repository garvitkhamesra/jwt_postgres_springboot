package com.garvit.fylebackend.auth.controller;

import com.garvit.fylebackend.auth.config.JwtTokenUtil;
import com.garvit.fylebackend.auth.domain.request.LoginCredentials;
import com.garvit.fylebackend.auth.domain.response.JwtResponse;
import com.garvit.fylebackend.auth.service.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * User: garvit
 * Date: 12/11/19 2:55 PM
 */

@RestController
@CrossOrigin
@Slf4j
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                                    JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody LoginCredentials loginCredentials) {
        try {
            authenticate(loginCredentials.getUsername(), loginCredentials.getPassword());
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(loginCredentials.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            log.error("Exception : ", e);
            return ResponseEntity.unprocessableEntity().body(e);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
