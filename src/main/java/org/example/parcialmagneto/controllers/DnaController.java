package org.example.parcialmagneto.controllers;

import org.example.parcialmagneto.services.DnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaService)
    {
        this.dnaService = dnaService;
    }

    @PostMapping
    public ResponseEntity<String> isMutant(@RequestBody Map<String, String[]> request) {
        try{
            String[] dna = request.get("dna");
            if (dna == null || dna.length == 0) {
                return new ResponseEntity<>("Invalid Dna Input", HttpStatus.BAD_REQUEST);
            }
            boolean result = dnaService.isMutant(dna);
            return result ? ResponseEntity.ok("Mutante detectado")
                    : ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es mutante");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
