package org.upskill;

/**
 * Representa um funcionário associado a um ginasio, que é uma extensão de Pessoa. Possui um identificador único,
 * um nome, uma morada, um género, uma data de nascimento, um número de clientes angariados, um vencimento base e um preço
 * por cliente angariado.
 */
public class Funcionario extends Pessoa implements Pagamento {
    //variaveis de instancia
    private int numeroClientesAngariados;
    private final int NUMEROCLENTESANGARIADOS_POR_OMISSAO = 0;

    //variaveis de classe
    private static int idCont = 0;
    private static double vencimentoBase = 800;
    private static double precoPorClienteAngariado = 20;


    /**
     * Construtor que permite a criação de um funcionário com um nome, uma morada, um género, uma data de nascimento
     * e um número de clientes angariados.
     * @param nome O nome do funcionário.
     * @param morada A morada do funcionário.
     * @param genero O género do funcionário.
     * @param dataNascimento A data de nascimento do funcionário.
     * @param numeroClientesAngariados O número de clientes angariados pelo funcionário.
     */
    public Funcionario( String nome, String morada, String genero, Data dataNascimento, int numeroClientesAngariados) {
        super("FUNC-"+ ++idCont, nome, morada, genero, dataNascimento);
        this.numeroClientesAngariados = numeroClientesAngariados;
    }
    public Funcionario(){
        super();
        numeroClientesAngariados= NUMEROCLENTESANGARIADOS_POR_OMISSAO;
    }

    /**
     * Obtém a representação em string do funcionário, incluindo identificador, nome, morada, género, data de nascimento,
     * número de clientes angariados, vencimento base e preço por cliente angariado.
     * @return Uma string formatada com as características do funcionário.
     */
    @Override
    public String toString() {
        return String.format("Funcionario: identificador='%s', nome='%s', morada='%s', genero='%s', dataNascimento=%s, numeroClientesAngariados=%d, vencimentoBase=%.2f€, precoPorClienteAngariado=%.2f€ ",
                getIdentificador(),
                getNome(),
                getMorada(),
                getGenero(),
                getDataNascimento(),
                numeroClientesAngariados,
                vencimentoBase,
                precoPorClienteAngariado);
    }

    /**
     * Verifica se dois funcionários são iguais, comparando identificador, nome, morada, género, data de nascimento
     * e número de clientes angariados.
     * @param o Objeto a ser comparado.
     * @return true se os funcionários forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return numeroClientesAngariados == that.numeroClientesAngariados;
    }

    /**
     * Calcula o vencimento do funcionário, somando o vencimento base ao produto do número de clientes angariados pelo
     * preço por cliente angariado.
     * @return O vencimento total do funcionário.
     */
    public double calcularVencimento(){
        return vencimentoBase + numeroClientesAngariados * precoPorClienteAngariado;
    }

}
