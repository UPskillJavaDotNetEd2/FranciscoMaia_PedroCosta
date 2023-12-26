package org.upskill;

import java.util.*;

/**
 * Representa um ginasio que possui um nome, uma morada e uma lista de pessoas associadas.
 */
public class Ginasio {
    //Variaveis de instância
    private String nome;
    private String morada;
    private ArrayList<Pessoa> pessoas;

    //Constantes por omissão
    private final String NOME_POR_OMISSAO = "Sem nome";
    private final String MORADA_POR_OMISSAO = "Sem morada";

    /**
     * Construtor que permite a criação de um ginasio com um nome, uma morada e uma lista de pessoas.
     * @param nome O nome do ginasio.
     * @param morada A morada do ginasio.
     * @param pessoas A lista de pessoas associadas ao ginasio.
     */
    public Ginasio(String nome,String morada,ArrayList<Pessoa> pessoas){
        this.nome = nome;
        this.morada = morada;
        this.pessoas = new ArrayList<>(pessoas);
    }

    /**
     * Construtor que permite a criação de um ginasio com um nome e uma morada, inicializando a lista de pessoas vazia.
     * @param nome O nome do ginasio.
     * @param morada A morada do ginasio.
     */
    public Ginasio(String nome,String morada){
        this.nome = nome;
        this.morada = morada;
        this.pessoas = new ArrayList<>();
    }

    /**
     * Construtor que permite a criação de um ginasio com nome e morada por omissão, inicializando a lista de pessoas vazia.
     */
    public Ginasio(){
        this.nome = NOME_POR_OMISSAO;
        this.morada = MORADA_POR_OMISSAO;
        pessoas = new ArrayList<>();
    }

    /**
     * Obtém o nome do ginasio.
     * @return O nome do ginasio.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a morada do ginasio.
     * @return A morada do ginasio.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Obtém uma cópia da lista de pessoas associadas ao ginasio.
     * @return A lista de pessoas associadas ao ginasio.
     */
    public ArrayList<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }

    /**
     * Define o nome do ginasio.
     * @param nome O novo nome do ginasio.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a morada do ginasio.
     * @param morada A nova morada do ginasio.
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Define a lista de pessoas associadas ao ginasio.
     * @param pessoas A nova lista de pessoas.
     */
    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = new ArrayList<>(pessoas);
    }

    /**
     * Adiciona uma pessoa à lista de pessoas associadas ao ginasio, caso ela não exista na lista.
     * @param pessoa A pessoa a ser adicionada.
     * @return true se a pessoa foi adicionada, false caso contrário.
     */
    public boolean adicionarPessoa(Pessoa pessoa){
        if(!pessoas.contains(pessoa)){
            pessoas.add(pessoa);
            return true;
        }
        return false;
    }

    /**
     * Remove uma pessoa da lista de pessoas associadas ao ginasio, caso ela exista na lista.
     * @param pessoa A pessoa a ser removida.
     * @return true se a pessoa foi removida, false caso contrário.
     */
    public boolean removerPessoa(Pessoa pessoa){
        if(pessoas.contains(pessoa)){
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }

    /**
     * Calcula os custos totais com treinadores, somando os vencimentos dos treinadores associados ao ginasio.
     * @return Os custos totais com treinadores.
     */
    public double calcularCustosTreinadores(){
        double custosTreinadores = 0;
        for (Pessoa p : pessoas) {
            if(p instanceof Treinador){
                custosTreinadores += ((Treinador) p).calcularVencimento();
            }
        }
        return custosTreinadores;
    }

    /**
     * Calcula os custos totais com funcionários, somando os vencimentos dos funcionários associados ao ginasio.
     * @return Os custos totais com funcionários.
     */
    public  double calcularCustosFuncionarios(){
        double custosFuncionarios = 0 ;
        for (Pessoa p : pessoas) {
            if(p instanceof Funcionario ){
                custosFuncionarios += ((Funcionario) p).calcularVencimento();
            }
        }
        return custosFuncionarios;
    }

    /**
     * Calcula os ganhos totais com clientes, somando as mensalidades dos clientes associados ao ginasio.
     * @return Os ganhos totais com clientes.
     */
    public double calcularGanhosClientes(){
        double ganhosClientes = 0;
        for (Pessoa p : pessoas) {
            if(p instanceof Cliente){
                ganhosClientes += ((Cliente) p).calculoMensalidade();
            }
        }
        return ganhosClientes;
    }

    /**
     * Lista as pessoas associadas ao ginasio em ordem alfabética.
     */
    public void listarPessoasOrdemAlfabetica() {
        ArrayList<Pessoa> copiapessoas = new ArrayList<>(pessoas);
        Collections.sort(copiapessoas);

        for (Pessoa p : copiapessoas) {
            System.out.println(p);
        }
    }

    /**
     * Lista as mensalidades dos clientes ativos em ordem decrescente.
     */
    public void listarOrdemDecrescenteMensalidada(){
        CriterioMensalidadeDecrescente c1 = new CriterioMensalidadeDecrescente();
        ArrayList<Cliente> copiaClientes = new ArrayList<>();

        for (Pessoa p: pessoas) {
            if(p instanceof Cliente){
                copiaClientes.add((Cliente) p);
            }
        }
        copiaClientes.sort(c1);
        for (Cliente p: copiaClientes) {
            if(p instanceof Regular && ((Regular)p).isAtivo()){
                System.out.format("Nome: %s - Mensalidade: %.2f€\n",p.getNome(),((Regular) p).calculoMensalidade());
            }
        }
    }

    /**
     * Lista todas as pessoas associadas ao ginasio.
     */
    public void listar(){
        for (Pessoa p: pessoas) {
            System.out.println(p);
        }
    }

    /**
     * Lista os clientes ordenados por IMC, em caso de empate lista por aulas decrescente e em novo caso de empate lista por ordem alfabética
     */
    public void listarPorImc(){
        CriterioOrdemImc c2 = new CriterioOrdemImc();
        ArrayList<Cliente> copiaClientes = new ArrayList<>();

        for (Pessoa p: pessoas) {
            if(p instanceof Cliente){
                copiaClientes.add((Cliente) p);
            }
        }
        copiaClientes.sort(c2);
        for (Cliente p: copiaClientes) {
            System.out.format("Nome: %s IMC: %.1f Numero de aulas: %d\n",p.getNome(),((Cliente)p).calcularIMC(),((Cliente) p).calcularNumeroAulasTotais());
        }
    }

    /**
     * Lista os treinadores associados ao ginasio, apresentando nome, idade, número de sessões e vencimento.
     */
    public void listarTreinadores(){
        for (Pessoa p: pessoas) {
            if(p instanceof Treinador){
                System.out.printf("Nome:%s Idade:%d Numero sessoes:%d Vencimento:%.2f€\n",p.getNome(),((Treinador) p).calcularIdade(),((Treinador) p).getNumeroSessaoPT(),((Treinador) p).calcularVencimento());
            }
        }
    }


    /**
     * Verifica se dois ginasios são iguais, comparando nome, morada e lista de pessoas.
     * @param o Objeto a ser comparado.
     * @return true se os ginasios forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ginasio ginasio = (Ginasio) o;
        return Objects.equals(nome, ginasio.nome) && Objects.equals(morada, ginasio.morada) && Objects.equals(pessoas, ginasio.pessoas) && Objects.equals(NOME_POR_OMISSAO, ginasio.NOME_POR_OMISSAO) && Objects.equals(MORADA_POR_OMISSAO, ginasio.MORADA_POR_OMISSAO);
    }

    /**
     * Representação textual do ginasio, mostrando o nome, a morada e a lista de pessoas associadas.
     * @return Uma string formatada com as características do ginasio.
     */
    @Override
    public String toString() {
        return String.format("Ginasio: nome='%s', morada='%s', pessoas=%s",
                nome,
                morada,
                pessoas);
    }


}
