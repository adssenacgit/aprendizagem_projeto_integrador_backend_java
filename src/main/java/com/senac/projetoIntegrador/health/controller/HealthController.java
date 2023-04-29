package com.senac.projetoIntegrador.health.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senac.projetoIntegrador.health.response.HealthResponse;


@RestController
@RequestMapping(value = "/health", produces = "application/json")
public class HealthController {
    
    @GetMapping
    public ResponseEntity<HealthResponse> health(){
        HealthResponse response = new HealthResponse("ok");
        return new ResponseEntity<HealthResponse>(response, HttpStatus.OK);
    }

}
