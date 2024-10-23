package org.example.parcialmagneto.services;


import org.example.parcialmagneto.repositories.DnaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DnaServiceTest {

    @Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private DnaService dnaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRows() {
        String[] dna = {
                "CAAAAA",
                "CCGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCGTA",
                "TCACTG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void testColumns() {
        String[] dna = {
                "ACGTAG",
                "CCGTGC",
                "TTATGC",
                "ACCTAG",
                "CCCGTC",
                "TCACTG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    // Este metodo evalua las diagonales de Izquierda a Derecha
    public void testDiagonalsIzqADer() {
        String[] dna = {
                "ACGTAG",
                "CCGTGC",
                "TTCCGC",
                "ACCCAG",
                "CCCGCC",
                "TCACTG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    // Este metodo evalua las diagonales de Derecha a Izquierda
    public void testDiagonalsDerAIzq() {
        String[] dna = {
                "ACGAAG",
                "CCGTGC",
                "TTATGC",
                "ACTTAG",
                "CTCGTC",
                "TCACTG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void testNoMutant() {
        String[] dna = {
                "ACGTAG",
                "CCGTGC",
                "TTACGC",
                "ACCTAG",
                "CCCGTC",
                "TCACTG"
        };
        assertFalse(dnaService.isMutant(dna));
    }

    // Lo mismo pero con una matriz más pequeña
    @Test
    public void smallTestRows() {
        String[] dna = {
                "ACGT",
                "CCCC",
                "TTAG",
                "GCTA"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void smallTestColumns() {
        String[] dna = {
                "ACGT",
                "ACGC",
                "ATAG",
                "ACTA"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void smallTestDiagonalsIzqADer() {
        String[] dna = {
                "ACGT",
                "TAGC",
                "TTAG",
                "GCTA"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void smallTestDiagonalsDerAIzq() {
        String[] dna = {
                "ACGT",
                "TCTC",
                "TTAG",
                "TCTA"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void smallTestNoMutant() {
        String[] dna = {
                "ACGT",
                "TCGC",
                "TTAG",
                "GCTA"
        };
        assertFalse(dnaService.isMutant(dna));
    }

    // Con una matriz más grande

    @Test
    public void bigTestRows() {
        String[] dna = {
                "ACGTAGTTC",
                "CCGTGCACG",
                "TTAAGCCCA",
                "ACCTAGTAC",
                "CTCGTCTTG",
                "TCACTGGAG",
                "TCCGAATGA",
                "CGGGGATGT",
                "AAACTTCGG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void bigTestColumns() {
        String[] dna = {
                "ACGTAGTTC",
                "CCGTGCACG",
                "TTAAGCCCA",
                "ACCTAGTAC",
                "CTCGTCTTG",
                "TCACTGGAT",
                "TCCGAATGT",
                "CGGGAATGT",
                "AAACTTCGT"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void bigTestDiagonalsIzqADer() {
        String[] dna = {
                "ACGTAGTTC",
                "CCGTGCACG",
                "TTAAGCCCA",
                "ACCTAGTAC",
                "CTCGTCTTG",
                "TCACTGGAG",
                "TCCGCATGA",
                "CGGGACTGT",
                "AAACTTCGG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void bigTestDiagonalsDerAIzq() {
        String[] dna = {
                "ACGTAGTTC",
                "CCGTGCACG",
                "TTAAGCCCA",
                "ACCTAGTAC",
                "CTCGTCTTG",
                "TCACTGGAG",
                "TCCGGATGA",
                "CGGGAATGT",
                "AAGCTTCGG"
        };
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void bigTestNoMutant() {
        String[] dna = {
                "ACGTAGTTC",
                "CCGTGCACG",
                "TTAAGCCCA",
                "ACCTAGTAC",
                "CTCGTCTTG",
                "TCACTGGAG",
                "TCCGAATGA",
                "CGGGAATGT",
                "AAACTTCGG"
        };
        assertFalse(dnaService.isMutant(dna));
    }
}

