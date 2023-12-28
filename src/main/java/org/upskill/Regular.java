package org.upskill;

/**
 * Representa um cliente do tipo Regular.
 * Estende a classe Cliente e implementa métodos específicos para este tipo de cliente.
 */
public class Regular extends Cliente {
    // Variáveis de instância
    private double mensalidadeFixa;
    private int numeroSessoesPT;
    private double precoSessao;
    private boolean ativo;


    // Variáveis de classe
    private static int idCont = 0;
    private static double precoPrimeirasTres = 5;
    private static double precoRestantes = 3;

    // Construtores

    /**
     * Construtor completo para criar uma instância de cliente Regular.
     *
     * @param nome              Nome do cliente.
     * @param morada            Morada do cliente.
     * @param genero            Género do cliente.
     * @param dataNascimento    Data de nascimento do cliente.
     * @param altura            Altura do cliente.
     * @param peso              Peso do cliente.
     * @param mensalidade       Mensalidade fixa do cliente.
     * @param numeroSessoesPT   Número de sessões de Personal Trainer do cliente.
     * @param precoSessao       Preço por sessão de Personal Trainer do cliente.
     * @param numeroAulas       Numero de aulas regulares
     */
    public Regular(String nome, String morada, String genero, Data dataNascimento, int altura, double peso, double mensalidade, int numeroAulasHidroginastica, int numeroSessoesPT, double precoSessao,int numeroAulas) {
        super("CLI-REGULAR-" + ++idCont, nome, morada, genero, dataNascimento, TipoCliente.REGULAR, altura, peso,numeroAulas,numeroAulasHidroginastica);
        setMensalidadeFixa(mensalidade);
        this.ativo = true;
        setPrecoSessao(precoSessao);
        setNumeroSessoesPT(numeroSessoesPT);
    }

    // Métodos de acesso

    /**
     * Obtém a mensalidade fixa do cliente Regular.
     *
     * @return Mensalidade fixa do cliente Regular.
     */
    public double getMensalidadeFixa() {
        return mensalidadeFixa;
    }

    /**
     * Obtém o preço para as primeiras três aulas de hidroginástica do cliente Regular.
     *
     * @return Preço para as primeiras três aulas de hidroginástica do cliente Regular.
     */
    public static double getPrecoPrimeirasTres() {
        return precoPrimeirasTres;
    }

    /**
     * Obtém o preço para as restantes aulas de hidroginástica do cliente Regular.
     *
     * @return Preço para as restantes aulas de hidroginástica do cliente Regular.
     */
    public static double getPrecoRestantes() {
        return precoRestantes;
    }

    /**
     * Obtém o número de sessões de Personal Trainer do cliente Regular.
     *
     * @return Número de sessões de Personal Trainer do cliente Regular.
     */
    public int getNumeroSessoesPT() {
        return numeroSessoesPT;
    }

    /**
     * Obtém o preço por sessão de Personal Trainer do cliente Regular.
     *
     * @return Preço por sessão de Personal Trainer do cliente Regular.
     */
    public double getPrecoSessao() {
        return precoSessao;
    }

    /**
     * Verifica se o cliente Regular está ativo.
     *
     * @return true se o cliente Regular estiver ativo, false caso contrário.
     */
    public boolean isAtivo() {
        return ativo;
    }

    // Métodos de modificação
    /**
     * Define a mensalidade fixa do cliente Regular.
     *
     * @param mensalidadeFixa Nova mensalidade fixa do cliente Regular.
     */
    public void setMensalidadeFixa(double mensalidadeFixa) {
        if (mensalidadeFixa < 0) {
            throw new IllegalArgumentException("A mensalidade fixa não pode ser negativa.");
        }
        this.mensalidadeFixa = mensalidadeFixa;
    }


    /**
     * Define o preço para as primeiras três aulas de hidroginástica do cliente Regular.
     *
     * @param precoPrimeirasTres Novo preço para as primeiras três aulas de hidroginástica do cliente Regular.
     */
    public static void setPrecoPrimeirasTres(double precoPrimeirasTres) {
        Regular.precoPrimeirasTres = precoPrimeirasTres;
    }

    /**
     * Define o preço para as restantes aulas de hidroginástica do cliente Regular.
     *
     * @param precoRestantes Novo preço para as restantes aulas de hidroginástica do cliente Regular.
     */
    public static void setPrecoRestantes(double precoRestantes) {
        Regular.precoRestantes = precoRestantes;
    }

    /**
     * Define o número de sessões de Personal Trainer do cliente Regular.
     *
     * @param numeroSessoesPT Novo número de sessões de Personal Trainer do cliente Regular.
     */
    public void setNumeroSessoesPT(int numeroSessoesPT) {
        if (numeroSessoesPT < 0) {
            throw new IllegalArgumentException("O número de sessões de Personal Trainer não pode ser negativo.");
        }
        this.numeroSessoesPT = numeroSessoesPT;
    }

    /**
     * Define o preço por sessão de Personal Trainer do cliente Regular.
     *
     * @param precoSessao Novo preço por sessão de Personal Trainer do cliente Regular.
     */
    public void setPrecoSessao(double precoSessao) {
        if (precoSessao < 0) {
            throw new IllegalArgumentException("O preço por sessão não pode ser negativo.");
        }
        this.precoSessao = precoSessao;
    }

    /**
     * Define o estado de atividade do cliente Regular.
     *
     * @param ativo Novo estado de atividade do cliente Regular.
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Obtém o contador de IDs estáticos para a classe Regular.
     *
     * @return Contador de IDs estáticos.
     */
    public static int getIdCont(){
        return idCont;
    }

    // Representação textual

    /**
     * Retorna uma representação textual do cliente Regular.
     *
     * @return Representação textual do cliente Regular.
     */
    @Override
    public String toString() {
        return String.format("%sRegular: mensalidadeFixa=%.2f€, quantidadeSessoesPT=%d, precoSessao=%.2f€, ativo=%s",
                super.toString(),
                mensalidadeFixa,
                numeroSessoesPT,
                precoSessao,
                ativo);
    }

    // Métodos de instância

    /**
     * Calcula a mensalidade total do cliente Regular.
     *
     * @return Mensalidade total do cliente Regular.
     */
    public double calculoMensalidade() {
        double custoAulasHidroginastica = 0;
        if (getNumeroAulasHidroginastica() <= 3) {
            custoAulasHidroginastica *= getNumeroAulasHidroginastica() * precoPrimeirasTres;
        } else {
            custoAulasHidroginastica = 3 * precoPrimeirasTres + (getNumeroAulasHidroginastica() - 3) * precoRestantes;
        }
        return mensalidadeFixa + custoAulasHidroginastica + numeroSessoesPT * precoSessao;
    }

    /**
     * Compara este cliente Regular com outro objeto para igualdade.
     *
     * @param o Objeto a ser comparado com este cliente Regular.
     * @return true se o objeto é igual a este cliente Regular, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Regular regular = (Regular) o;
        return Double.compare(mensalidadeFixa, regular.mensalidadeFixa) == 0 && numeroSessoesPT == regular.numeroSessoesPT && Double.compare(precoSessao, regular.precoSessao) == 0 && ativo == regular.ativo;
    }


}
