package org.example.parcialmagneto.repositories;

import org.example.parcialmagneto.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    boolean existsByDna(String dna);
    Dna findByDna(String dna);

    long countByIsMutantTrue();
    long countByIsMutantFalse();
}

