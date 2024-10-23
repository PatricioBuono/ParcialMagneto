package org.example.parcialmagneto.services;


import org.example.parcialmagneto.entities.Dna;
import org.example.parcialmagneto.repositories.DnaRepository;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    private final DnaRepository dnaRepository;

    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean isMutant(String[] dna) {
        int n = dna.length;

        if (checkRows(dna, n) || checkColumns(dna, n) || checkDiagonals(dna, n)){
            saveDna(dna, true);
            System.out.println("Es mutante");
            return true;
        } // No uso el else porque estan los return
        saveDna(dna, false);
        System.out.println("No es mutante");
        return false;
    }

    private boolean checkRows(String[] dna, int n) {
        for (String row : dna){
            for (int i = 0; i <= n-4; i++){
                if (row.charAt(i) == row.charAt(i+1) &&
                        row.charAt(i+1) == row.charAt(i+2) &&
                        row.charAt(i+2) == row.charAt(i+3)){
                    System.out.println("Positivo en Filas");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns(String[] dna, int n) {
        for (int col = 0; col < n; col++){
            for (int row = 0; row <= n-4; row++){
                if (dna[row].charAt(col) == dna[row+1].charAt(col) &&
                        dna[row+1].charAt(col) == dna[row+2].charAt(col) &&
                        dna[row+2].charAt(col) == dna[row+3].charAt(col)){
                    System.out.println("Positivo en Columnas");
                    return true;
                }
            }
        }
        return false;
    }


    private boolean checkDiagonals(String[] dna, int n) {
        for (int row = 0; row <= n-4; row++){
            for (int col = 0; col <= n-4; col++){
                if(dna[row].charAt(col) == dna[row+1].charAt(col+1) &&
                        dna[row+1].charAt(col+1) == dna[row+2].charAt(col+2) &&
                        dna[row+2].charAt(col+2) == dna[row+3].charAt(col+3)){
                    System.out.println("Positivo en Diagonales de Izquierda a Derecha");
                    return true;
                }
            }
        }

        // Revisa las diagonales de derecha a izquierda
        for (int row = 0; row <= n-4; row++){
            for (int col = 3; col < n; col++){
                if (dna[row].charAt(col) == dna[row+1].charAt(col-1) &&
                        dna[row+1].charAt(col-1) == dna[row+2].charAt(col-2) &&
                        dna[row+2].charAt(col-2) == dna[row+3].charAt(col-3)){
                    System.out.println("Positivo en Diagonales de Derecha a Izquierda");
                    return true;
                }
            }
        }

        return false;
    }

    // Este metodo convierte un array en un string y lo guarda en la BD
    private void saveDna(String[] dna, boolean isMutant) {
        String dnaStr = String.join(",", dna);
        Dna dnaEntity = new Dna(dnaStr, isMutant);
        dnaRepository.save(dnaEntity);
    }

}

