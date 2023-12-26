package org.upskill;

/**
 * Esta classe implementa o critério de ordenação para objetos do tipo Cliente
 * com base na mensalidade em ordem decrescente.
 */

import java.util.Comparator;

public class CriterioMensalidadeDecrescente implements Comparator<Cliente> {
    /**
     * Compara dois objetos do tipo Cliente com base na mensalidade em ordem decrescente.
     *
     * @param c1 O primeiro objeto Cliente a ser comparado.
     * @param c2 O segundo objeto Cliente a ser comparado.
     * @return Um valor negativo se o primeiro objeto for menor que o segundo,
     *         um valor positivo se o primeiro objeto for maior que o segundo,
     *         zero se os objetos forem iguais.
     */
    @Override
    public int compare(Cliente c1, Cliente c2) {
        double pagamento1 = c1.calculoMensalidade();
        double pagamento2 = c2.calculoMensalidade();

        // Comparação com base na mensalidade em ordem decrescente
        return Double.compare(pagamento2, pagamento1);
    }
}

