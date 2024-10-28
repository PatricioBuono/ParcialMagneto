package org.example.parcialmagneto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsResponse {

    private long countMutantDna;
    private long countHumanDna;
    private double ratio;
}
