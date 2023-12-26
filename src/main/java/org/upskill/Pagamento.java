package org.upskill;

/**
 * Interface que define o contrato para objetos que calculam vencimentos.
 */
public interface Pagamento {
    /**
     * Calcula o vencimento associado a uma determinada entidade.
     *
     * @return O vencimento calculado.
     */
    public abstract double calcularVencimento();
}
