import java.util.Scanner;

import Controller.Atendimento;
import Controller.Gestao;

public class App {
    public static void main() {
        Atendimento atendimento = new Atendimento();
        Gestao gestao = new Gestao();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            Atendimento.limparTerminal();
            System.out.println("Menu Principal:");
            System.out.println("1. Menu de Atendimento");
            System.out.println("2. Menu de Gestao");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    atendimento.menu();
                    break;
                case 2:
                    gestao.menu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (opcao != 0);
        scanner.close();

    }
}
