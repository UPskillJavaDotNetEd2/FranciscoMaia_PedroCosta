package org.upskill;

import java.util.Calendar;

/**
 * Representa um treinador, que é uma extensão da classe Pessoa e implementa a interface Pagamento.
 * Contém informações sobre o preço da sessão, vencimento e número de sessões de treino personalizado.
 */
public class Treinador extends Pessoa implements Pagamento {
    // Variáveis de instância
    private double precoSessao;
    private double vencimento;
    private int numeroSessaoPT;

    // Variáveis de classe
    private static int idCont = 1;

    // Construtores
    /**
     * Construtor que inicializa as características básicas do treinador.
     * @param nome Nome do treinador.
     * @param morada Morada do treinador.
     * @param genero Género do treinador.
     * @param dataNascimento Data de nascimento do treinador.
     * @param precoSessao Preço por sessão de treino personalizado.
     * @param vencimento Vencimento base do treinador.
     * @param numeroSessaoPT Número de sessões de treino personalizado.
     */
    public Treinador(String nome, String morada, String genero, Data dataNascimento, double precoSessao, double vencimento, int numeroSessaoPT) {
        super("TREI-" + idCont++, nome, morada, genero, dataNascimento);
        this.precoSessao = precoSessao;
        this.vencimento = vencimento;
        this.numeroSessaoPT = numeroSessaoPT;
    }


    // Gets de instância
    /**
     * Obtém o preço por sessão de treino personalizado.
     * @return O preço por sessão.
     */
    public double getPrecoSessao() {
        return precoSessao;
    }

    /**
     * Obtém o vencimento base do treinador.
     * @return O vencimento base.
     */
    public double getVencimento() {
        return vencimento;
    }

    /**
     * Obtém o número de sessões de treino personalizado.
     * @return O número de sessões.
     */
    public int getNumeroSessaoPT() {
        return numeroSessaoPT;
    }

    // Sets de instância
    /**
     * Define o preço por sessão de treino personalizado.
     * @param precoSessao O novo preço por sessão.
     */
    public void setPrecoSessao(double precoSessao) {
        this.precoSessao = precoSessao;
    }

    /**
     * Define o vencimento base do treinador.
     * @param vencimento O novo vencimento base.
     */
    public void setVencimento(double vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * Define o número de sessões de treino personalizado.
     * @param numeroSessaoPT O novo número de sessões.
     */
    public void setNumeroSessaoPT(int numeroSessaoPT) {
        this.numeroSessaoPT = numeroSessaoPT;
    }

    // Métodos de instância
    /**
     * Calcula o vencimento total do treinador, levando em conta o número de sessões de treino personalizado.
     * @return O vencimento total.
     */
    public double calcularVencimento() {
        return vencimento + (numeroSessaoPT * precoSessao);
    }

    /**
     * Calcula a idade do treinador com base na data de nascimento.
     * @return A idade do treinador.
     */
    public int calcularIdade() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int mesAtual = Calendar.getInstance().get(Calendar.MONTH) + 1; // janeiro é representado por 0.
        int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - getDataNascimento().getAno();

        // Verifica se já fez anos neste ano
        if (mesAtual < getDataNascimento().getMes() || (mesAtual == getDataNascimento().getMes() && diaAtual < getDataNascimento().getDia())) {
            idade--;
        }

        return idade;
    }

    // toString
    /**
     * Representação textual do treinador.
     * @return Uma string formatada com as características do treinador.
     */
    @Override
    public String toString() {
        return String.format("%sTreinador{precoSessao=%.2f€, vencimento=%.2f€, numeroSessaoPT=%d ",
                super.toString(),
                precoSessao,
                vencimento,
                numeroSessaoPT);
    }

    // Equals
    /**
     * Compara se dois treinadores são iguais.
     * @param o Objeto a ser comparado.
     * @return true se os treinadores forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Treinador treinador = (Treinador) o;
        return Double.compare(precoSessao, treinador.precoSessao) == 0 && Double.compare(vencimento, treinador.vencimento) == 0 && numeroSessaoPT == treinador.numeroSessaoPT;
    }
}
