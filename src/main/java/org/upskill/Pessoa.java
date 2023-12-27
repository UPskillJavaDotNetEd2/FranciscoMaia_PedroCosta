package org.upskill;

import java.util.Objects;

/**
 * Representa uma entidade genérica de pessoa.
 * Implementa a interface Comparable para permitir comparações entre instâncias.
 */
public class Pessoa implements Comparable<Pessoa> {
    // Variáveis de instância
    private String identificador;
    private String nome;
    private String morada;
    private String genero;
    private Data dataNascimento;
    private String ID_POR_OMISSAO = "Sem Id";
    private String NOME_POR_OMISSAO = "Sem nome";
    private String MORADA_POR_OMISSAO = "Sem morada";
    private String GENERO_POR_OMISSAO = "Sem genero";
    private Data DATA_POR_OMISSAO = new Data();

    // Construtores
    /**
     * Construtor completo para criar uma instância de Pessoa.
     *
     * @param identificador Identificador único da pessoa.
     * @param nome          Nome da pessoa.
     * @param morada        Morada da pessoa.
     * @param genero        Género da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     */
    // Construtor completo
    public Pessoa(String identificador, String nome, String morada, String genero, Data dataNascimento) {
        setIdentificador(identificador);
        setNome(nome);
        setMorada(morada);
        setGenero(genero);
        setDataNascimento(dataNascimento);
    }

    /**
     * Construtor vazio para criar uma instância de Pessoa com valores por omissão.
     */
    public Pessoa() {
        this.identificador = ID_POR_OMISSAO;
        this.nome = NOME_POR_OMISSAO;
        this.morada = MORADA_POR_OMISSAO;
        this.genero = GENERO_POR_OMISSAO;
        this.dataNascimento = DATA_POR_OMISSAO;
    }

    /**
     * Construtor de cópia para criar uma instância de Pessoa com base noutra Pessoa.
     *
     * @param outraPessoa Outra Pessoa a ser copiada.
     */
    public Pessoa(Pessoa outraPessoa) {
        this.identificador = outraPessoa.identificador;
        this.nome = outraPessoa.nome;
        this.morada = outraPessoa.morada;
        this.genero = outraPessoa.genero;
        this.dataNascimento = new Data(outraPessoa.dataNascimento);
    }

    // Métodos de acesso

    /**
     * Obtém o identificador da pessoa.
     *
     * @return Identificador da pessoa.
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a morada da pessoa.
     *
     * @return Morada da pessoa.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Obtém o género da pessoa.
     *
     * @return Género da pessoa.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return Data de nascimento da pessoa.
     */
    public Data getDataNascimento() {
        return new Data(dataNascimento);
    }

    // Métodos de modificação

    /**
     * Define o identificador da pessoa.
     *
     * @param identificador Novo identificador da pessoa.
     */
    public void setIdentificador(String identificador) {
        if (identificador == null || identificador.trim().isEmpty()) {
            throw new IllegalArgumentException("O identificador não pode ser nulo ou vazio.");
        }
        this.identificador = identificador;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome Novo nome da pessoa.
     */
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Define a morada da pessoa.
     *
     * @param morada Nova morada da pessoa.
     */
    public void setMorada(String morada) {
        if (morada == null || morada.trim().isEmpty()) {
            throw new IllegalArgumentException("A morada não pode ser nula ou vazia.");
        }
        this.morada = morada;
    }

    /**
     * Define o género da pessoa.
     *
     * @param genero Novo género da pessoa.
     */
    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("O género não pode ser nulo ou vazio.");
        }
        this.genero = genero;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataNascimento Nova data de nascimento da pessoa.
     */
    public void setDataNascimento(Data dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("A data de nascimento não pode ser nula.");
        }
        this.dataNascimento = dataNascimento;
    }

    // Representação textual

    /**
     * Retorna uma representação textual da pessoa.
     *
     * @return Representação textual da pessoa.
     */
    // toString
    @Override
    public String toString() {
        return String.format(
                "Pessoa identificador='%s', nome='%s', morada='%s', genero='%s', dataNascimento=%s",
                identificador, nome, morada, genero, dataNascimento.toAnoMesDiaString()
        );
    }

    // Métodos de comparação

    /**
     * Compara esta pessoa com outra pessoa com base nos nomes.
     *
     * @param outraPessoa Outra pessoa a ser comparada.
     * @return Um valor negativo se esta pessoa preceder a outra, um valor positivo se a outra pessoa preceder esta,
     *         ou zero se ambas forem iguais em termos de nome.
     */
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.getNome().compareTo(outraPessoa.getNome());
    }

    // Métodos de igualdade

    /**
     * Indica se outra pessoa é igual a esta pessoa.
     *
     * @param o Objeto a ser comparado com esta pessoa.
     * @return true se o objeto é igual a esta pessoa, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(identificador, pessoa.identificador) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(morada, pessoa.morada) &&
                Objects.equals(genero, pessoa.genero) &&
                Objects.equals(dataNascimento, pessoa.dataNascimento);
    }
}
