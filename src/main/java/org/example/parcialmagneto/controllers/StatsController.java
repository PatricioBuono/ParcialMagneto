package org.example.parcialmagneto.controllers;

import org.example.parcialmagneto.dto.StatsResponse;
import org.example.parcialmagneto.repositories.DnaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final DnaRepository dnaRepository;

    public StatsController(final DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    @GetMapping
    public ResponseEntity<StatsResponse> getStats() {
        long countMutantDna = dnaRepository.countByIsMutantTrue();
        long countHumanDna = dnaRepository.countByIsMutantFalse();
        double ratio = countHumanDna > 0 ? (double) countMutantDna/countHumanDna : 0.0;

        StatsResponse stats = new StatsResponse(countMutantDna, countHumanDna, ratio);
        return ResponseEntity.ok(stats);
    }
}
