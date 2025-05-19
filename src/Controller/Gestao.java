package Controller;

import java.util.Scanner;

import models.Estacionamento;

public class Gestao {
    Scanner scr = new Scanner(System.in);
    public static Estacionamento estacionamento = new Estacionamento(10, 2);

    public void menu() {
        int opcao = 0;

        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Menu: ");
            System.out.println("1. Cadastrar vagas");
            System.out.println("2. Excluir vagas");
            System.out.println("3. Alterar tarifas");
            System.out.println("4. Listagem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: \n> ");
            opcao = scr.nextInt();

            switch (opcao) {
                // case 1:
                //     this.limparTerminal();
                //     estacionamento.adicionarVaga();
                //     break;
                // case 2:
                //     this.limparTerminal();
                //     estacionamento.removerVaga();
                //     break;
                // case 3:
                //     this.limparTerminal();
                //     estacionamento.alterarTarifa();
                //     break;
                // case 4:
                //     this.limparTerminal();
                //     estacionamento.listarVagas();
                //     break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

    

}
