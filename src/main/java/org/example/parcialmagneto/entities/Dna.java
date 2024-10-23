package org.example.parcialmagneto.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dna extends Base{

    private String dna;
    private boolean isMutant;
}
