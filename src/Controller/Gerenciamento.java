package Controller;

import java.util.Scanner;

import BD.BDVeiculos;

public class Gerenciamento {
    Scanner scr = new Scanner(System.in);
    BDVeiculos veiculos = new BDVeiculos();

    public void menuAtendimento() {
        int opcao = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Pesquisar carro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: \n> ");
            opcao = scr.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite a placa do carro para pesquisar: \n> ");
                    String placa = scr.next();
                    System.out.println("\tPesquisando carro da placa: " + placa);
                    try {
                        System.out.println(veiculos.buscarVeiculo(placa).toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
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

    public void menuGestao() {
        int opcao = 0;

        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Menu:");
            System.out.println("1. Cadastrar vagas");
            System.out.println("2. Excluir vagas");
            System.out.println("3. Alterar tarifas");
            System.out.println("4. Listagem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: \n> ");
            opcao = scr.nextInt();

            switch (opcao) {
                case 1:
                    
                    System.out.print("\nDigite a placa do carro para pesquisar: \n> ");
                    String placa = scr.next();
                    System.out.println("\tPesquisando carro da placa: " + placa);
                    try {
                        System.out.println(veiculos.buscarVeiculo(placa).toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    this.limparTerminal();
                    System.out.println("Alterar tarifas:");
                    System.out.print("Nova tarifa para CARRO: ");
                    double tarifaCarro = scr.nextDouble();
                    enums.Tipo.CARRO.setTarifa(tarifaCarro);
                    System.out.print("Nova tarifa para MOTO: ");
                    double tarifaMoto = scr.nextDouble();
                    enums.Tipo.MOTO.setTarifa(tarifaMoto);
                    System.out.print("Nova tarifa para UNITARIO: ");
                    double tarifaUnitario = scr.nextDouble();
                    enums.Tipo.UNITARIO.setTarifa(tarifaUnitario);
                    System.out.println("Tarifas atualizadas com sucesso!");
                    break;

                case 4:

                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void menuListagem() {
        int opcao = 0;

        do {
            System.out.println("\n\n\nMenu Listagem:");
        } while (opcao != 0);
    }
}
