package org.upskill;

/**
 * Representa um cliente convidado em um centro de fitness.
 * Estende a classe {@link Cliente} e inclui propriedades específicas para um cliente convidado.
 */
public class Convidado extends Cliente {

    //variaveis de instancia
    private int horasGratis;
    private int numeroSessaoComPT;
    private double precoSessaoPT;

    //constantes
    private int HORAS_GRATIS_POR_OMISSAO = 0;
    private int NUMERO_SESSAO_COM_PT_POR_OMISSAO = 0;
    private int PRECO_SESSAO_PT_POR_OMISSAO = 0;


    //variaveis de classe
    private static int idCont = 0;
    private static double precoAula = 6;
    private static double precoAulaHidroginastica = 7;
    private static double precoHora = 6;

    //contrutor completo
    /**
     * Construtor completo para a classe Convidado.
     *
     * @param nome                     O nome do convidado.
     * @param morada                   O endereço do convidado.
     * @param genero                   O gênero do convidado.
     * @param dataNascimento           A data de nascimento do convidado.
     * @param altura                   A altura do convidado.
     * @param peso                     O peso do convidado.
     * @param horasGratis              O número de horas gratuitas concedidas ao convidado.
     * @param numeroHoras              O número total de horas que o convidado esteve no ginasio.
     * @param numeroDeAulas            O número de aulas regulares de fitness que o convidado pode frequentou.
     * @param numeroDeAulasHidroginastica O número de aulas de hidroginástica que o convidado pode frequentou.
     * @param numeroSessaoComPT        O número de sessões de treinamento pessoal que o convidado teve.
     * @param precoSessaoPT            O preço por sessão de treinamento pessoal para o convidado.
     */
    public Convidado(String nome, String morada, String genero, Data dataNascimento,  int altura, double peso, int horasGratis, double numeroHoras, int numeroDeAulas, int numeroDeAulasHidroginastica, int numeroSessaoComPT, int precoSessaoPT) {
        super("CLI-ESPORÁDICO-" + ++idCont, nome, morada, genero, dataNascimento, TipoCliente.CONVIDADO, altura, peso,numeroDeAulas,numeroDeAulasHidroginastica,numeroHoras);
        this.horasGratis = horasGratis;
        this.numeroSessaoComPT = numeroSessaoComPT;
        this.precoSessaoPT = precoSessaoPT;
    }

    //construtor vazio
    /**
     * Construtor vazio que inicializa as variáveis de instância com valores padrão.
     */
    public Convidado(){
        super();
        horasGratis = HORAS_GRATIS_POR_OMISSAO;
        numeroSessaoComPT = NUMERO_SESSAO_COM_PT_POR_OMISSAO;
        precoSessaoPT = PRECO_SESSAO_PT_POR_OMISSAO;
    }

    // Métodos getters
    /**
     * Obtém a quantidade de clientes inscritos no ginasio do tipo convidado.
     *
     * @return O numero de clientes do tipo convidado.
     */
    public static int getIdCont() {
        return idCont;
    }
    /**
     * Obtém o número de horas gratuitas concedidas ao convidado.
     *
     * @return O número de horas gratuitas.
     */
    public int getHorasGratis() {
        return horasGratis;
    }
    /**
     * Obtém o preço por aula regular no ginasio.
     *
     * @return O preço por aula.
     */
    public static double getPrecoAula() {
        return precoAula;
    }
    /**
     * Obtém o preço por aula de hidroginastica no ginasio.
     *
     * @return O preço por aula de hidroginastica.
     */

    public static double getPrecoAulaHidroginastica() {
        return precoAulaHidroginastica;
    }
    /**
     * Obtém o preço por sessão de treinamento pessoal para o convidado.
     *
     * @return O preço por sessão de treinamento pessoal.
     */
    public double getPrecoSessaoPT() {
        return precoSessaoPT;
    }
    /**
     * Obtém o preço por hora no ginasio para o convidado.
     *
     * @return O preço hora no ginasio.
     */
    public static double getPrecoHora() {
        return precoHora;
    }





    // Métodos setters
    /**
     * Define o preço por aula regular para o convidado.
     *
     * @param precoAula O novo preço por aula regular a ser definido.
     */
    public static void setPrecoAula(double precoAula) {
        Convidado.precoAula = precoAula;
    }

    // Métodos setters
    /**
     * Define o preço por aula de hidroginastica para o convidado.
     *
     * @param precoAulaHidroginastica O novo preço por aula de hidroginastica a ser definido.
     */
    public static void setPrecoAulaHidroginastica(double precoAulaHidroginastica) {
        Convidado.precoAulaHidroginastica = precoAulaHidroginastica;
    }
    // Métodos setters
    /**
     * Define o preço por hora livre no ginasio para convidado.
     *
     * @param precoHora O novo preço por hora a ser definido.
     */
    public static void setPrecoHora(double precoHora) {
        Convidado.precoHora = precoHora;
    }
    // Métodos setters
    /**
     * Define o numero de horas gratis que o cliente pode usar no ginasio.
     *
     * @param horasGratis O novo numero de horas gratis.
     */
    public void setHorasGratis(int horasGratis) {
        this.horasGratis = horasGratis;
    }
    /**
     * Obtém o número de sessões de treinamento pessoal que o convidado teve.
     *
     * @return O número de sessões de treinamento pessoal.
     */

    public int getNumeroSessaoComPT() {
        return numeroSessaoComPT;
    }
    /**
     * Define o número de sessões de treinamento pessoal que o convidado teve.
     *
     * @param numeroSessaoComPT O novo número de sessões de treinamento pessoal a ser definido.
     */
    public void setNumeroSessaoComPT(int numeroSessaoComPT) {
        this.numeroSessaoComPT = numeroSessaoComPT;
    }
    /**
     * Define o preço por sessão de treinamento pessoal para o convidado.
     *
     * @param precoSessaoPT O novo preço por sessão de treinamento pessoal a ser definido.
     */
    public void setPrecoSessaoPT(int precoSessaoPT) {
        this.precoSessaoPT = precoSessaoPT;
    }
    /**
     * Retorna uma representação em formato de string do objeto Convidado.
     *
     * @return Uma string que representa o objeto Convidado.
     */
    @Override
    public String toString() {
        return String.format("%sConvidado{horasGratis=%d, numeroSessaoComPT=%d, precoSessaoPT=%.2f",
                super.toString(),
                horasGratis,
                numeroSessaoComPT,
                precoSessaoPT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Convidado convidado = (Convidado) o;
        return horasGratis == convidado.horasGratis && numeroSessaoComPT == convidado.numeroSessaoComPT && Double.compare(precoSessaoPT, convidado.precoSessaoPT) == 0 ;
    }

    /**
     * Calcula o custo da mensalidade de convidado.
     *
     * @return O custo da mensalidade de convidado.
     */

    @Override
    public double calculoMensalidade() {
        return calcularCustoAulas()+calcularCustoAulasHidroginastica()+calcularCustoHorasLivres()+ calcularCustoSessoesPT();
    }
    /**
     * Calcula o custo das horas livres excedentes do convidado.
     *
     * @return O custo das horas livres excedentes.
     */
    public double calcularCustoHorasLivres(){
        if(getNumeroHoras() -getNumeroAulas()*getDuracaoAula()-getNumeroAulasHidroginastica()*getDuracaoAula()>horasGratis){
            return ((getNumeroHoras() -getNumeroAulas()*getDuracaoAula()-getNumeroAulasHidroginastica()*getDuracaoAula())-horasGratis) * precoHora;
        }else return 0;
    }
    /**
     * Calcula o custo das sessões de treinamento pessoal do convidado.
     *
     * @return O custo das sessões de treinamento pessoal.
     */
    public double calcularCustoSessoesPT(){
        return numeroSessaoComPT* precoSessaoPT;
    }
    /**
     * Calcula o custo das aulas regulares do convidado.
     *
     * @return O custo das aulas regulares.
     */
    public double calcularCustoAulas(){
        return getNumeroAulas() * precoAula;
    }

    /**
     * Calcula o custo das aulas de hidroginástica do convidado.
     *
     * @return O custo das aulas de hidroginástica.
     */
    public double calcularCustoAulasHidroginastica(){
        return getNumeroAulasHidroginastica() * precoAulaHidroginastica;
    }

}
