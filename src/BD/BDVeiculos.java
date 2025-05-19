package BD;

import enums.Tipo;
import models.Veiculo;

public class BDVeiculos {
    private Veiculo[] veiculos = new Veiculo[10];
    private int quantVeiculos = 0;
    
    public BDVeiculos() {
        init();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if(quantVeiculos == 100) 
            throw new IllegalArgumentException("Banco de dados de veículos cheio.");
        
        for(Veiculo v : veiculos) {
            if(v != null && v.placa().equals(veiculo.placa())) {
                throw new IllegalArgumentException("Veículo já cadastrado.");
            }
        }

        for(int i = 0; i < veiculos.length; i++) {
            if(veiculos[i] == null) {
                veiculos[i] = veiculo;
                System.out.println("Veículo adicionado com sucesso.");
                return;
            }
        }
    }

    public void removerVeiculo(String placa) {
        for(int i = 0; i < veiculos.length; i++) {
            if(veiculos[i] != null && veiculos[i].placa().equals(placa)) {
                veiculos[i] = null;
                System.out.println("Veículo removido com sucesso.");
                return;
            }
        }
        throw new IllegalArgumentException("Veículo não encontrado.");
    }

    public Veiculo buscarVeiculo(String placa) {
        for(Veiculo v : veiculos) {
            if(v != null && v.placa().equals(placa)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Veículo nao encontrado.");
    }

    public void init() {
        this.adicionarVeiculo(new Veiculo("ABC1D23", "Fusca", "azul", "VW", Tipo.CARRO));
        this.adicionarVeiculo(new Veiculo("DEF4G56", "Civic", "preto", "HONDA", Tipo.CARRO));
        this.adicionarVeiculo(new Veiculo("MOT1P34", "CG 160", "vermelho", "HONDA", Tipo.MOTO));
        this.adicionarVeiculo(new Veiculo("MOT5C78", "Fazer 250", "preto", "YAMAHA", Tipo.MOTO));
        this.adicionarVeiculo(new Veiculo("ABD2I54", "Fusca", "preto", "VW", Tipo.CARRO));
    }

    private String lerTodosVeiculos() {
        StringBuilder sb = new StringBuilder();
        for(Veiculo v : veiculos) {
            if(v != null) {
                sb.append("\t\t> " + v.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "BDVeiculos \n " + this.lerTodosVeiculos() + " \nQuantVeiculos=" + quantVeiculos + "";
    }

    
    
}
