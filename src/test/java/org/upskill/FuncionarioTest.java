package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void calcularVencimentoFuncionarioTest() {
        Funcionario f1 = new Funcionario("Ana Costa", "Avenida X", "Feminino", new Data(1966, 10, 10), 15);
        double result = f1.calcularVencimento();
        double expResult = 1100;
        assertEquals(expResult,result,0.01);
    }
}