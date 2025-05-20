package Controller;

import java.util.Scanner;

import BD.DBEstacionamento;
import enums.Tipo;
import models.Veiculo;

public class Gestao {
    Scanner scr = new Scanner(System.in);
    public static DBEstacionamento estacionamento = new DBEstacionamento(10, 2);

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
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: \n> ");
            opcao = scr.nextInt();

            switch (opcao) {
                case 1:
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
                        Atendimento.veiculos.adicionarVeiculo(new Veiculo(placaAdicionar, modelo, cor, marca, tipo));
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                    // case 2:
                    // this.limparTerminal();
                    // estacionamento.removerVaga();
                    // break;
                case 3:
                    Atendimento.limparTerminal();
                    try {
                        System.out.print("\nDigite o tipo que queria modificar: \n> ");
                        Tipo tipo = Tipo.valueOfIgnoreCase(scr.next().toUpperCase());
                        System.out.print("Digite a nova tarifa: \n> ");
                        double tarifa = scr.nextDouble();
                        Tipo.modificarTarifaPorNome(tipo.name(), tarifa);
                        System.out.println("Tarifa " + tipo.name() + " alterada para: " + tipo.getTarifa());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Digite qualquer tecla para continuar...");
                        scr.next();
                    }
                case 4:
                    Atendimento.limparTerminal();
                    try {
                        System.out.println("Listagem de veiculos: ");
                        System.out.println(estacionamento.toString());
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

}
