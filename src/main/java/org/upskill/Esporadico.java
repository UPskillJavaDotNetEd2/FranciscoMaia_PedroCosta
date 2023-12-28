package org.upskill;

/**
 * Representa um cliente esporádico de um ginasio, que é uma extensão de Outro. Possui um identificador único,
 * um nome, uma morada, um género, uma data de nascimento, uma altura, um peso, um número de aulas, um número de aulas
 * de hidroginástica, um número de horas, um preço por aula, um preço por aula de hidroginástica, um preço por hora e
 * um preço por hora extra.
 */

public class Esporadico extends Cliente {


    // Variáveis de classe
    private static int idCont = 0;
    private static double precoAula = 6;
    private static double precoAulaHidroginastica = 7;
    private static double precoHora = 5;
    private static double precoHoraExtra = 5;

    // Construtores

    /**
     * Construtor que permite a criação de um cliente esporádico com um nome, uma morada, um género, uma data de nascimento,
     * uma altura, um peso, um número de aulas, um número de aulas de hidroginástica e um número de horas.
     * @param nome O nome do cliente esporádico.
     * @param morada A morada do cliente esporádico.
     * @param genero O género do cliente esporádico.
     * @param dataNascimento A data de nascimento do cliente esporádico.
     * @param altura A altura do cliente esporádico.
     * @param peso O peso do cliente esporádico.
     * @param numeroAulas O número de aulas do cliente esporádico.
     * @param numeroAulasHidroginastica O número de aulas de hidroginástica do cliente esporádico.
     * @param numeroHoras O número de horas do cliente esporádico.
     */
    public Esporadico(String nome, String morada, String genero, Data dataNascimento, int altura, double peso, int numeroAulas, int numeroAulasHidroginastica, double numeroHoras) {
        super("CLI-ESPORÁDICO-" + ++idCont, nome, morada, genero, dataNascimento, TipoCliente.ESPORADICO, altura, peso, numeroAulas, numeroAulasHidroginastica, numeroHoras);
    }


    /**
     * Construtor vazio que cria um cliente esporádico com valores por omissão.
     */
    public Esporadico() {
        super();
    }

    /**
     * Obtém o identificador único do cliente esporádico.
     * @return O identificador único do cliente esporádico.
     */
    public static int getIdCont() {
        return idCont;
    }

    /**
     * Obtém o preço por aula do cliente esporádico.
     * @return O preço por aula do cliente esporádico.
     */
    public static double getPrecoAula() {
        return precoAula;
    }

    /**
     * Obtém o preço por hora do cliente esporádico.
     * @return O preço por hora do cliente esporádico.
     */
    public static double getPrecoHora() {
        return precoHora;
    }

    /**
     * Obtém o preço por hora extra do cliente esporádico.
     * @return O preço por hora extra do cliente esporádico.
     */
    public static double getPrecoHoraExtra() {
        return precoHoraExtra;
    }

    /**
     * Define o preço por aula do cliente esporádico.
     * @param precoAula O preço por aula a ser definido.
     */
    public static void setPrecoAula(double precoAula) {
        if (precoAula <= 0) {
            throw new IllegalArgumentException("O preço a pagar por aula deve ser superior a 0.");
        }
        Esporadico.precoAula = precoAula;
    }

    /**
     * Define o preço por hora do cliente esporádico.
     * @param precoHora O preço por hora a ser definido.
     */
    public static void setPrecoHora(double precoHora) {
        if (precoAulaHidroginastica <= 0) {
            throw new IllegalArgumentException("O preço a pagar por hora deve ser superior a 0.");
        }
        Esporadico.precoHora = precoHora;
    }

    /**
     * Define o preço por hora extra do cliente esporádico.
     * @param precoHoraExtra O preço por hora extra a ser definido.
     */
    public static void setPrecoHoraExtra(double precoHoraExtra) {
        if (precoAulaHidroginastica <= 0) {
            throw new IllegalArgumentException("O preço a pagar por hora deve ser superior a 0.");
        }
        Esporadico.precoHoraExtra = precoHoraExtra;
    }


    /**
     * Calcula a mensalidade do cliente esporádico, somando o custo das aulas, o custo das aulas de hidroginástica e
     * o custo das horas livres.
     * @return O valor total da mensalidade do cliente esporádico.
     */
    public double calculoMensalidade() {
        return calcularCustoAulas() + calcularCustoAulasHidroginastica() + calcularCustoHorasLivres();
    }

    /**
     * Calcula o custo das aulas do cliente esporádico, multiplicando o número de aulas pelo preço por aula.
     * @return O custo total das aulas do cliente esporádico.
     */
    public double calcularCustoAulas() {
        return getNumeroAulas() * precoAula;
    }

    /**
     * Calcula o custo das aulas de hidroginástica do cliente esporádico, multiplicando o número de aulas de
     * hidroginástica pelo preço por aula de hidroginástica.
     * @return O custo total das aulas de hidroginástica do cliente esporádico.
     */
    public double calcularCustoAulasHidroginastica() {
        return getNumeroAulasHidroginastica() * precoAulaHidroginastica;
    }

    /**
     * Calcula o custo das horas livres do cliente esporádico, subtraindo o número total de horas ocupadas pelo custo
     * do número total de horas permitidas, multiplicado pelo preço por hora.
     * @return O custo total das horas livres do cliente esporádico.
     */
    public double calcularCustoHorasLivres() {
        if (getNumeroHoras() > getNumeroAulas() * getDuracaoAula() + getNumeroAulasHidroginastica()* getDuracaoAula()) {
            return (getNumeroHoras() - getNumeroAulas() * getDuracaoAula() - getNumeroAulasHidroginastica() * getDuracaoAula()) * precoHora;
        }
        return 0;
    }

    /**
     * Verifica se dois clientes esporádicos são iguais, comparando o número de horas, o número de aulas e o número de
     * aulas de hidroginástica.
     * @param o Objeto a ser comparado.
     * @return true se os clientes esporádicos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Esporadico that = (Esporadico) o;
        return Double.compare(getNumeroHoras(), that.getNumeroHoras()) == 0 && getNumeroAulas() == that.getNumeroAulas() && getNumeroAulasHidroginastica() == that.getNumeroAulasHidroginastica();
    }
}
