package org.upskill;


import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Regular regular1 = new Regular("Pedro", "Amarante", "Masculino", new Data(1995, 6, 11), 201, 80, 80, 7, 8, 20, 12);
        Regular regular2 = new Regular("Miguel", "Amarante2", "Masculino", new Data(1999, 3, 12), 200, 80, 80, 35, 11, 20, 7);
        Regular regular3 = new Regular("Costa", "Amarante3", "Masculino", new Data(1991, 4, 5), 200, 80, 50, 16, 9, 20, 15);
        regular3.setAtivo(false);

        Esporadico esporadico1 = new Esporadico("Cristiano Ronaldo", "Morada 3", "Masculino", new Data(1998, 3, 15), 175, 75, 3, 12, 20);
        Esporadico esporadico2 = new Esporadico("Joana Rocha", "Morada 4", "Feminino", new Data(1992, 8, 20), 180, 80, 26, 7, 42);
        Esporadico esporadico3 = new Esporadico("Ruben Silva", "Morada 4", "Masculino", new Data(1990, 8, 20), 180, 80, 28, 5, 53);

        Convidado convidado1 = new Convidado("Miguel Teixeira", "Morada 6", "Masculino", new Data(1988, 11, 8), 155, 50, 8, 83, 25, 5, 5, 20);
        Convidado convidado2 = new Convidado("Ana Silva", "Morada 6", "Feminino", new Data(1985, 10, 8), 155, 50, 3, 65, 6, 16, 5, 35);
        Convidado convidado3 = new Convidado("Abel Sousa", "Morada 7", "Masculino", new Data(1990, 11, 28), 155, 50, 3, 46, 8, 15, 10, 40);

        Treinador treinador1 = new Treinador("João Silva", "Rua A", "Masculino", new Data(1992, 4, 2), 50.0, 1000.0, 10);
        Treinador treinador2 = new Treinador("Maria Oliveira", "Rua B", "Feminino", new Data(1995, 6, 1), 45.0, 1200.0, 8);
        Treinador treinador3 = new Treinador("Pedro Santos", "Rua C", "Masculino", new Data(1990, 1, 1), 55.0, 900.0, 12);

        Funcionario funcionario1 = new Funcionario("Ana Costa", "Avenida X", "Feminino", new Data(1966, 10, 10), 15);
        Funcionario funcionario2 = new Funcionario("Carlos Rocha", "Rua Y", "Masculino", new Data(1960, 4, 4), 10);
        Funcionario funcionario3 = new Funcionario("Marta Oliveira", "Bairro Z", "Feminino", new Data(2000, 9, 20), 20);

        //▪ criação de uma instância da classe Ginásio;
        Ginasio g1 = new Ginasio("Gym", "Amarante");

        //Adiciona clientes,funcionarios e treinadores ao ginasio
        g1.adicionarPessoa(regular1);
        g1.adicionarPessoa(regular2);
        g1.adicionarPessoa(regular3);

        g1.adicionarPessoa(esporadico1);
        g1.adicionarPessoa(esporadico2);
        g1.adicionarPessoa(esporadico3);

        g1.adicionarPessoa(convidado1);
        g1.adicionarPessoa(convidado2);
        g1.adicionarPessoa(convidado3);

        g1.adicionarPessoa(treinador1);
        g1.adicionarPessoa(treinador2);
        g1.adicionarPessoa(treinador3);

        g1.adicionarPessoa(funcionario1);
        g1.adicionarPessoa(funcionario2);
        g1.adicionarPessoa(funcionario3);

        //▪ criação de uma listagem de Treinadores, apresentando o nome dos Treinadores, a sua idade,
        //o número de sessões como Personal Trainer e o seu vencimento no final do mês;
        System.out.println("-----Treinadores");
        g1.listarTreinadores();
        System.out.println();

        //▪ apresentação da quantidade de instâncias de clientes criados, sem percorrer o contentor;
        System.out.println("-----Numero Total de Clientes inscritos no ginasio");
        System.out.println("Clientes Inscritos no ginasio: " + (Regular.getIdCont() + Esporadico.getIdCont() + Convidado.getIdCont()));
        System.out.println();

        //▪ calcular e apresentar o valor a pagar por cada tipo de cliente, percorrendo apenas uma vez o
        //contentor. Deve ser também calculado e apresentado o valor total a pagar por todos os
        //clientes;
        System.out.println("-----Calcular mensalidade para cada tipo de cliente");
        double mensalidaTotalConvidados = 0;
        double mensalidaTotalEsporadicos = 0;
        double mensalidaTotalRegulares = 0;
        for (Pessoa c : g1.getPessoas()) {
            if (c instanceof Convidado) {
                mensalidaTotalConvidados += ((Convidado) c).calculoMensalidade();
            }
            if (c instanceof Esporadico) {
                mensalidaTotalEsporadicos += ((Esporadico) c).calculoMensalidade();
            }
            if (c instanceof Regular) {
                mensalidaTotalRegulares += ((Regular) c).calculoMensalidade();
            }
        }
        System.out.format("Mensalidade total dos clientes Convidados: %.2f€\n", mensalidaTotalConvidados);
        System.out.format("Mensalidade total dos clientes Esporadicos: %.2f€\n", mensalidaTotalEsporadicos);
        System.out.format("Mensalidade total dos clientes Regulares: %.2f€\n", mensalidaTotalRegulares);
        System.out.format("Mensalidade total de todos os clientes: %.2f€\n", mensalidaTotalRegulares + mensalidaTotalConvidados + mensalidaTotalEsporadicos);
        System.out.println();

        //▪ calcular e apresentar o saldo obtido pelo ginásio nesse mês mediante as receitas dos clientes
        //e custos com os seus Funcionários e Treinadores;
        System.out.println("-----Lucro do ginásio");
        System.out.println("Ganhos com os clientes: " + g1.calcularGanhosClientes() + "€");
        System.out.println("Custos com os funcionarios: " + g1.calcularCustosFuncionarios() + "€");
        System.out.println("Custos com os treinadores: " + g1.calcularCustosTreinadores() + "€");
        System.out.println("Balanço do mês:" + (g1.calcularGanhosClientes() - g1.calcularCustosFuncionarios() - g1.calcularCustosTreinadores()) + "€");
        System.out.println();

        //▪ calcular e apresentar, para cada género, a média do seu IMC;
        System.out.println("-----Média do IMC por Género");
        double mediaImcFeminino = 0;
        double mediaImcMasculino = 0;
        int contadorFeminino = 0;
        int contadorMasculino = 0;
        for (Pessoa c : g1.getPessoas()) {
            if (c instanceof Cliente && c.getGenero().equalsIgnoreCase("Feminino")) {
                mediaImcFeminino += ((Cliente) c).calcularIMC();
                contadorFeminino++;
            } else if (c instanceof Cliente && c.getGenero().equalsIgnoreCase("Masculino")) {
                mediaImcMasculino += ((Cliente) c).calcularIMC();
                contadorMasculino++;
            }
        }
        System.out.printf("Feminino: %.1f%n", mediaImcFeminino / contadorFeminino);
        System.out.printf("Masculino: %.1f%n", mediaImcMasculino / contadorMasculino);


        //▪ Retornar o nome do ginásio;
        System.out.println();
        System.out.println("-----Nome ginásio");
        System.out.println("Nome ginásio: " + g1.getNome());
        System.out.println();

        //▪ Retornar o valor dos vencimento de cada Funcionário;
        System.out.println("-----Vencimento de cada funcionário: ");
        for (Pessoa p : g1.getPessoas()) {
            if (p instanceof Funcionario) {
                System.out.printf("%s %.2f€%n", p.getNome(), ((Funcionario) p).calcularVencimento());
            }
        }
        System.out.println();
        //▪ Retornar o valor dos vencimento de cada Treinador;
        System.out.println("-----Vencimento de cada Treinador");
        for (Pessoa p : g1.getPessoas()) {
            if (p instanceof Treinador) {
                System.out.printf("%s %.2f€%n", p.getNome(), ((Treinador) p).calcularVencimento());
            }
        }
        System.out.println();

        //▪ Retornar uma lista de pessoas que frequentam o ginásio, ordenada alfabeticamente por
        //nome, usando a interface nativa do Java Comparable;
        System.out.println("-----Lista de pessoas que frequentam o ginásio por ordem alfabetica");
        g1.listarPessoasOrdemAlfabetica();
        System.out.println();

        //▪ Retornar uma lista de clientes Regulares que estejam ativos, por ordem decrescente do valor
        //a pagarem no final do mês, usando a interface nativa do Java Comparator;
        System.out.println("-----Lista de clientes Regular ativos por ordem decrescente da mensalidade");
        g1.listarOrdemDecrescenteMensalidada();
        System.out.println();

        //▪ Retornar uma lista de clientes, por ordem crescente do seu IMC e caso existam clientes com
        //o mesmo IMC, os clientes deverão ser apresentados por ordem decrescente do número de
        //aulas que frequentaram. Caso existam ainda clientes com o mesmo número de aulas que
        //frequentaram, os clientes deverão ser apresentados, por ordem alfabética dos seus nomes.
        System.out.println("-----Lista de clientes por ordem crescente do IMC");
        g1.listarPorImc();

        //Criar o objeto scanner para ler as entradas do utilizador
        Scanner scanner = new Scanner(System.in);
        Treinador treinador = criarTreinador(scanner);
        System.out.println("Treinador criado: "+treinador);

        //Chamar o método de criação de clientes regulares
        Regular regularInput = criarClienteRegular(scanner);

        System.out.println("Objeto Regular Criado:\n" + regularInput);
        System.out.println();

        Convidado convidadoTest = criarConvidado(scanner);
        System.out.println("Objeto Convidado Criado:\n" + convidadoTest);

        Esporadico esporadicoInput = criarEsporadicoComEntradasDoUtilizador();
        System.out.println("Objeto Convidado Criado:\n" + esporadicoInput);


    }

    // Método para criar um cliente Regular com entradas do utilizador
    private static Regular criarClienteRegular(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String morada = scanner.nextLine();

        System.out.println("Digite o gênero:");
        String genero = scanner.nextLine();

        System.out.println("Digite a data de nascimento (AAAA-MM-DD):");
        String dataNascimentoString = scanner.nextLine();
        Data dataNascimento = parseData(dataNascimentoString);

        System.out.println("Digite a altura:");
        int altura = scanner.nextInt();

        System.out.println("Digite o peso:");
        double peso = scanner.nextDouble();

        System.out.println("Digite a mensalidade fixa:");
        double mensalidadeFixa = scanner.nextDouble();

        System.out.println("Digite o número de aulas de hidroginástica:");
        int numeroAulasHidroginastica = scanner.nextInt();

        System.out.println("Digite o número de sessões de PT:");
        int numeroSessoesPT = scanner.nextInt();

        System.out.println("Digite o preço por sessão de PT:");
        double precoSessao = scanner.nextDouble();

        System.out.println("Digite o número de aulas regulares:");
        int numeroAulas = scanner.nextInt();

        scanner.nextLine();
        // Crie e retorne o objeto Regular com as entradas do usuário
        return new Regular(nome, morada, genero, dataNascimento, altura, peso, mensalidadeFixa, numeroAulasHidroginastica, numeroSessoesPT, precoSessao, numeroAulas);
    }

    private static Esporadico criarEsporadicoComEntradasDoUtilizador() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Obter as entradas do utilizador para o objeto Esporadico
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a morada: ");
            String morada = scanner.nextLine();

            System.out.print("Digite o género: ");
            String genero = scanner.nextLine();

            System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
            String dataNascimentoInput = scanner.nextLine();
            Data dataNascimento = parseData(dataNascimentoInput);

            System.out.print("Digite a altura: ");
            int altura = scanner.nextInt();

            System.out.print("Digite o peso: ");
            double peso = scanner.nextDouble();

            System.out.print("Digite o número de aulas regulares: ");
            int numAulasRegulares = scanner.nextInt();

            System.out.print("Digite o número de aulas de hidroginástica: ");
            int numAulasHidroginastica = scanner.nextInt();

            System.out.print("Digite o número de horas: ");
            double numHoras = scanner.nextDouble();

            scanner.nextLine();
            // Validar as entradas
            if (altura <= 0 || peso <= 0 || numAulasRegulares < 0 || numAulasHidroginastica < 0 || numHoras < 0) {
                throw new IllegalArgumentException("As entradas devem ser valores positivos.");
            }

            // Criar o objeto Esporadico com as entradas do usuário
            return new Esporadico(nome, morada, genero, dataNascimento, altura, peso, numAulasRegulares, numAulasHidroginastica, numHoras);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de fornecer o tipo de dados correto.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        } finally {
            // Fechar o scanner no bloco finally
            scanner.close();
        }
    }

    private static Convidado criarConvidado(Scanner scanner) {
        Convidado convidado = null;

        do {
            try {

                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite o endereço:");
                String morada = scanner.nextLine();

                System.out.println("Digite o gênero:");
                String genero = scanner.nextLine();

                System.out.println("Digite a data de nascimento (AAAA-MM-DD):");
                String dataNascimentoString = scanner.nextLine();
                Data dataNascimento = parseData(dataNascimentoString);

                System.out.println("Digite a altura:");
                int altura = scanner.nextInt();

                System.out.println("Digite o peso:");
                double peso = scanner.nextDouble();

                System.out.println("Digite o número de horas grátis:");
                int horasGratis = scanner.nextInt();

                System.out.println("Digite o numero de horas:");
                double numeroHoras = scanner.nextDouble();

                System.out.println("Digite o número de aulas:");
                int numeroAulas = scanner.nextInt();

                System.out.println("Digite o número de aulas de hidroginástica:");
                int numeroAulasHidroginastica = scanner.nextInt();

                System.out.println("Digite o número de sessões de PT:");
                int numeroSessoesPT = scanner.nextInt();

                System.out.println("Digite o preço por sessão de PT:");
                double precoSessaoPT = scanner.nextDouble();

                scanner.nextLine();
                // Tenta criar o objeto Convidado
                convidado = new Convidado(nome, morada, genero, dataNascimento, altura, peso, horasGratis, numeroHoras, numeroAulas, numeroAulasHidroginastica, numeroSessoesPT,precoSessaoPT);

                // Se chegou aqui, o objeto foi criado com sucesso, então sai do loop
                break;

            } catch (IllegalArgumentException e) {
                // Trate exceções específicas e forneça feedback ao usuário
                System.out.println("Erro: " + e.getMessage());
                // Limpe o buffer do scanner para evitar loops infinitos
                scanner.nextLine();
            }
        } while (true);

        return convidado;
    }
    private static Treinador criarTreinador(Scanner scanner) {
        Treinador treinador = null;

        do {
            try {
                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite o endereço:");
                String morada = scanner.nextLine();

                System.out.println("Digite o gênero:");
                String genero = scanner.nextLine();

                System.out.println("Digite a data de nascimento (AAAA-MM-DD):");
                String dataNascimentoString = scanner.nextLine();
                Data dataNascimento = parseData(dataNascimentoString);

                System.out.println("Digite o preço por sessão de PT:");
                double precoSessao = scanner.nextDouble();

                System.out.println("Digite o vencimento:");
                double vencimento = scanner.nextDouble();

                System.out.println("Digite o número de sessões de PT:");
                int numeroSessaoPT = scanner.nextInt();

                scanner.nextLine();

                // Tenta criar o objeto Treinador
                treinador = new Treinador(nome, morada, genero, dataNascimento, precoSessao, vencimento, numeroSessaoPT);

                // Se chegou aqui, o objeto foi criado com sucesso, então sai do loop
                break;

            } catch (IllegalArgumentException e) {
                // Trate exceções específicas e forneça feedback ao usuário
                System.out.println("Erro: " + e.getMessage());
                // Limpe o buffer do scanner para evitar loops infinitos
                scanner.nextLine();
            }
        } while (true);

        return treinador;
    }


    // Método auxiliar para analisar a string de data e transformar num objeto Data
    private static Data parseData(String dataString) {
        String[] partes = dataString.split("-");
        int ano = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);
        return new Data(ano, mes, dia);
    }
}
