package Controller;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import BD.BDVeiculos;
import enums.Tipo;
import models.Veiculo;

public class Atendimento {
    Scanner scr = new Scanner(System.in);
    public static BDVeiculos veiculos = new BDVeiculos();

    public void menu() {
        int opcao = 0;

        do {
            Atendimento.limparTerminal();
            System.out.println("Menu:");
            System.out.println("1. Pesquisar carro");
            System.out.println("2. Adicionar veiculo");
            System.out.println("3. Entrada do veiculo");
            System.out.println("4. Saida do veiculo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: \n> ");
            opcao = scr.nextInt();

            switch (opcao) {
                case 1:
                    Atendimento.limparTerminal();
                    System.out.print("\nDigite a placa do carro para pesquisar: \n> ");
                    String placa = scr.next();
                    System.out.println("\tPesquisando carro da placa: " + placa);
                    try {
                        System.out.println(veiculos.buscarVeiculo(Atendimento.verificarPlaca(placa)).toString());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                    break;
                case 2:
                    Atendimento.limparTerminal();
                    System.out.print("\nDigite a placa do carro para adicionar: \n> ");
                    String placaAdicionar = scr.next();
                    try {
                        placaAdicionar = Atendimento.verificarPlaca(placaAdicionar);
                        System.out.print("Digite o modelo do carro: \n> ");
                        String modelo = scr.next();
                        System.out.print("Digite a cor do carro: \n> ");
                        String cor = scr.next();
                        System.out.print("Digite a marca do carro: \n> ");
                        String marca = scr.next();
                        System.out.print("Digite o tipo do carro (CARRO, MOTO): \n> ");
                        Tipo tipo = Tipo.valueOfIgnoreCase(scr.next().toUpperCase());
                        veiculos.adicionarVeiculo(new Veiculo(placaAdicionar, modelo, cor, marca, tipo));
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                    break;
                case 3:
                    System.out.print("\nDigite a placa do carro para entrada: \n> ");
                    String placaEntrada = scr.next();
                    System.out.println("\tEntrada do veiculo de placa: " + placaEntrada);
                    try {
                        Gestao.estacionamento.setVaga(placaEntrada);
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                    break;
                case 4:
                    System.out.print("\nDigite a placa do carro para saida: \n> ");
                    String placaSaida = scr.next();
                    System.out.println("\tSaida do veiculo de placa: " + placaSaida);
                    try {
                        Veiculo veiculo = veiculos.buscarVeiculo(Atendimento.verificarPlaca(placaSaida));
                        Date dataEntrada = Gestao.estacionamento.limparVaga(placaSaida);
                        Time horaEntrada = new Time(System.currentTimeMillis());
                        System.out.println("Data de saida: " + dataEntrada.getTime());
                        System.out.println("Valor a pagar: " + Gestao.estacionamento.calcularTarifa(veiculo.getTipo(), dataEntrada, horaEntrada));
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível limpar o terminal.");
        }
    }

    public static String verificarPlaca(String placa) {
        if (placa == null) {
            throw new NullPointerException("Todos os campos devem ser preenchidos.");
        }
        if (placa.length() != 7) { // Placa merco sul tem no minino 7 caracteres
            throw new IllegalArgumentException("A placa deve ter 7 caracteres.");
        }
        if (!placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) { // Exemplo de como a placa merco sul é ABC1D23
            throw new IllegalArgumentException("A placa deve estar no formato Mercosul (ex: ABC1D23).");
        }
        return placa;
    }
}
