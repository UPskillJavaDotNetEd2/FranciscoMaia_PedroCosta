package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @org.junit.jupiter.api.Test
    void calcularIMCtesteEsporadico() {
        Esporadico c1 = new Esporadico("Cristiano Ronaldo", "Morada 3", "Masculino", new Data(1998, 3, 15), 175, 75, 3, 12, 1.5);
        double result = c1.calcularIMC();
        double expResult =24.49;
        assertEquals(expResult,result,0.01);
    }
    @org.junit.jupiter.api.Test
    void calcularIMCtesteConvidado() {
        Convidado c1 = new Convidado("Miguel Teixeira", "Morada 6", "Masculino", new Data(1988, 11, 8), 155, 50, 8, 6, 25, 5, 5, 20);
        double result = c1.calcularIMC();
        double expResult =20.81;
        assertEquals(expResult,result,0.01);
    }
    @org.junit.jupiter.api.Test
    void calcularIMCtesteRegular() {
        Regular r1 = new Regular("Pedro", "Amarante", "Masculino", new Data(1995, 6, 11), 201, 80, 80, 7, 8, 20,7);
        double result = r1.calcularIMC();
        double expResult =19.8;
        assertEquals(expResult,result,0.01);
    }
    @org.junit.jupiter.api.Test
    void calcularMensalidadeRegularTest() {
        Regular r1 = new Regular("Pedro", "Amarante", "Masculino", new Data(1995, 6, 11), 201, 80, 80, 7, 8, 20,15);
        double result = r1.calculoMensalidade();
        double expResult =267;
        assertEquals(expResult,result,0.01);
    }
    @org.junit.jupiter.api.Test
    void calcularMensalidadeConvidadoTest() {
        Convidado c1 = new Convidado("Miguel Teixeira", "Morada 6", "Masculino", new Data(1988, 11, 8), 155, 50, 8, 40, 25, 5, 5, 20);
        double result = c1.calculoMensalidade();
        double expResult =297;
        assertEquals(expResult,result,0.01);
    }
    @org.junit.jupiter.api.Test
    void calcularMensalidadeEsporadicoTest() {
        Esporadico c1 = new Esporadico("Cristiano Ronaldo", "Morada 3", "Masculino", new Data(1998, 3, 15), 175, 75, 3, 12, 20);
        double result = c1.calculoMensalidade();
        double expResult =127;
        assertEquals(expResult,result,0.01);
    }
}