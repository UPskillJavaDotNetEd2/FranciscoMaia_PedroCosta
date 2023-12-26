package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreinadorTest {

    @Test
    void calcularVencimentoTreinadorTest() {
        Treinador t1 = new Treinador("João Silva", "Rua A", "Masculino", new Data(1992, 4, 2), 50.0, 1000.0, 10);
        double result = t1.calcularVencimento();
        double expResult = 1500;
        assertEquals(expResult,result,0.01);
    }
}