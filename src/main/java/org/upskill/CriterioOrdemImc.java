package org.upskill;

import java.util.Comparator;

/**
 * Esta classe implementa o critério de ordenação para objetos do tipo Cliente
 * com base no Índice de Massa Corporal (IMC), número total de aulas e nome.
 * A ordenação é realizada da seguinte forma:
 * 1. IMC em ordem crescente.
 * 2. Número total de aulas em ordem decrescente.
 * 3. Nome em ordem alfabética (ignorando maiúsculas e minúsculas).
 */

public class CriterioOrdemImc implements Comparator {

    /**
     * Compara dois objetos do tipo Cliente com base no IMC, número total de aulas
     * e nome.
     *
     * @param p1 O primeiro objeto Cliente a ser comparado.
     * @param p2 O segundo objeto Cliente a ser comparado.
     * @return Um valor negativo se o primeiro objeto for menor que o segundo,
     *         um valor positivo se o primeiro objeto for maior que o segundo,
     *         zero se os objetos forem iguais.
     */
    public int compare(Object p1, Object p2){
        double imc1 = ((Cliente)p1).calcularIMC();
        double imc2 = ((Cliente)p2).calcularIMC();

        // Comparação com base no IMC
        if(imc1!=imc2){
            return Double.compare(imc1,imc2);
        }

        // Comparação com base no número total de aulas
        int aulasCliente1 = ((Cliente)p1).calcularNumeroAulasTotais();
        int aulasCliente2 = ((Cliente)p2).calcularNumeroAulasTotais();
        if(aulasCliente1!=aulasCliente2){
            return Integer.compare(aulasCliente2,aulasCliente1);
        }

        // Comparação com base no nome
        return ((Pessoa)p1).getNome().compareToIgnoreCase(((Pessoa)p2).getNome());
    }
}
