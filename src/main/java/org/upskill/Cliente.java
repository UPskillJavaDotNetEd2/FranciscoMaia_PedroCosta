package org.upskill;

/**
 * Esta classe abstrata representa um cliente no contexto de um ginasio.
 * Cada cliente possui um identificador único, nome, morada, género, data de nascimento,
 * tipo de cliente, altura e peso.
 * Além disso, um cliente pode calcular o seu Índice de Massa Corporal (IMC) e
 * tem um método abstrato para calcular o número total de aulas que frequentou.
 */

public abstract class Cliente extends Pessoa {

    // Variáveis de instância
    private int numeroAulas;
    private int numeroAulasHidroginastica;
    private double numeroHoras;
    private TipoCliente tipo;
    private int altura;
    private double peso;
    private static double duracaoAula = 1;



    // Constantes
    private final double NUMERO_HORAS_POR_OMISSAO = 0;
    private final int NUMERO_AULAS_POR_OMISSAO = 0;
    private final int NUMERO_AULAS_HIDROGINASTICA_POR_OMISSAO = 0;
    private static final TipoCliente TIPO_PADRAO = TipoCliente.REGULAR;
    private static final int ALTURA_PADRAO = 0;
    private static final double PESO_PADRAO = 0.0;

    // Construtor completo
    /**
     * Construtor completo para objetos da classe Cliente.
     *
     * @param identificador  O identificador do cliente.
     * @param nome           O nome do cliente.
     * @param morada         A morada do cliente.
     * @param genero         O género do cliente.
     * @param dataNascimento A data de nascimento do cliente.
     * @param tipo           O tipo de cliente.
     * @param altura         A altura do cliente em centímetros.
     * @param peso           O peso do cliente em quilogramas.
     */
    public Cliente(String identificador, String nome, String morada, String genero, Data dataNascimento,
                   TipoCliente tipo, int altura, double peso) {
        super(identificador, nome, morada, genero, dataNascimento);
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.numeroHoras = NUMERO_HORAS_POR_OMISSAO;
        this.numeroAulas = NUMERO_AULAS_POR_OMISSAO;
        this.numeroAulasHidroginastica = NUMERO_AULAS_HIDROGINASTICA_POR_OMISSAO;
    }
    public Cliente(String identificador, String nome, String morada, String genero, Data dataNascimento,
                   TipoCliente tipo, int altura, double peso,int numeroAulas,int numeroAulasHidroginastica,double numeroHoras) {
        super(identificador, nome, morada, genero, dataNascimento);
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.numeroAulas=numeroAulas;
        this.numeroAulasHidroginastica=numeroAulasHidroginastica;
        this.numeroHoras=numeroHoras;
    }
    public Cliente(String identificador, String nome, String morada, String genero, Data dataNascimento,
                   TipoCliente tipo, int altura, double peso,int numeroAulas,int numeroAulasHidroginastica) {
        super(identificador, nome, morada, genero, dataNascimento);
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.numeroAulas=numeroAulas;
        this.numeroAulasHidroginastica=numeroAulasHidroginastica;
        this.numeroHoras = NUMERO_HORAS_POR_OMISSAO;
    }

    // Construtor padrão utilizando constantes
    /**
     * Construtor padrão para objetos da classe Cliente.
     * Utiliza constantes predefinidas para valores padrão.
     */
    public Cliente() {
        super();
        this.tipo = TIPO_PADRAO;
        this.altura = ALTURA_PADRAO;
        this.peso = PESO_PADRAO;
        this.numeroHoras=NUMERO_HORAS_POR_OMISSAO;
        this.numeroAulas=NUMERO_AULAS_POR_OMISSAO;
        this.numeroAulasHidroginastica=NUMERO_AULAS_HIDROGINASTICA_POR_OMISSAO;
    }

    // Gets de instância
    /**
     * Obtém o tipo de cliente.
     *
     * @return O tipo de cliente.
     */
    public TipoCliente getTipo() {
        return tipo;
    }

    /**
     * Obtém a altura do cliente.
     *
     * @return A altura do cliente em centímetros.
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Obtém o peso do cliente.
     *
     * @return O peso do cliente em quilogramas.
     */
    public double getPeso() {
        return peso;
    }
    public double getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * Obtém o número de aulas regulares frequentadas pelo cliente.
     *
     * @return O número de aulas regulares frequentadas pelo cliente.
     */
    public int getNumeroAulas() {
        return numeroAulas;
    }
    /**
     * Obtém a duração padrão de uma aula.
     *
     * @return A duração padrão de uma aula.
     */
    public static double getDuracaoAula() {
        return duracaoAula;
    }

    /**
     * Define a duração padrão de uma aula.
     *
     * @param duracao A nova duração padrão de uma aula.
     */
    public static void setDuracaoAula(double duracao) {
        duracaoAula = duracao;
    }

    /**
     * Obtém o número de aulas de hidroginástica frequentadas pelo cliente.
     *
     * @return O número de aulas de hidroginástica frequentadas pelo cliente.
     */
    public int getNumeroAulasHidroginastica() {
        return numeroAulasHidroginastica;
    }

    /**
     * Define o número total de horas de atividade do cliente.
     *
     * @param numeroHoras O novo número total de horas de atividade do cliente.
     */
    public void setNumeroHoras(double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * Define o número de aulas regulares frequentadas pelo cliente.
     *
     * @param numeroDeAulas O novo número de aulas regulares frequentadas pelo cliente.
     */
    public void setNumeroAulas(int numeroDeAulas) {
        this.numeroAulas = numeroDeAulas;
    }

    /**
     * Define o número de aulas de hidroginástica frequentadas pelo cliente.
     *
     * @param numeroDeAulasHidroginastica O novo número de aulas de hidroginástica frequentadas pelo cliente.
     */
    public void setNumeroAulasHidroginastica(int numeroDeAulasHidroginastica) {
        this.numeroAulasHidroginastica = numeroDeAulasHidroginastica;
    }


    // Sets de instância
    /**
     * Define o tipo de cliente.
     *
     * @param tipo O tipo de cliente a ser atribuído.
     */
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    /**
     * Define a altura do cliente.
     *
     * @param altura A altura do cliente a ser atribuída em centímetros.
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Define o peso do cliente.
     *
     * @param peso O peso do cliente a ser atribuído em quilogramas.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }


    // Método de instância
    /**
     * Calcula o Índice de Massa Corporal (IMC) do cliente.
     *
     * @return O IMC do cliente.
     */
    public double calcularIMC() {
        return peso / Math.pow((double) altura / 100 , 2);
    }

    /**
     * Retorna uma representação em formato de string do objeto Cliente, incluindo informações sobre o tipo,
     * altura e peso.
     *
     * @return A representação em formato de string do objeto Cliente.
     */
    @Override
    public String toString() {
        return String.format("%sCliente{tipo=%s, altura=%.2fm, peso=%.2fKg}",
                super.toString(),
                tipo,
                (double) altura / 100,
                peso);
    }

    /**
     * Compara este cliente com outro objeto para verificar se são iguais.
     * Dois clientes são considerados iguais se possuírem o mesmo tipo, altura e peso.
     *
     * @param o O objeto a ser comparado com este cliente.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return altura == cliente.altura && Double.compare(peso, cliente.peso) == 0 && tipo == cliente.tipo;
    }


    // Método abstratos de instância
    /**
     * Calcula a mensalidade do cliente.
     *
     * @return A mensalidade do cliente.
     */
    public abstract double calculoMensalidade();

    /**
     * Calcula o número total de aulas do cliente.
     * Este método é abstrato e deve ser implementado por subclasses para fornecer o cálculo específico
     * do número total de aulas.
     *
     * @return O número total de aulas do cliente.
     */
    public  int calcularNumeroAulasTotais(){
        return numeroAulas+numeroAulasHidroginastica;
    };
}
