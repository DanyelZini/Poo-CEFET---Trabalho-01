package models;

import enums.Marca;
import enums.Tipo;

public record Veiculo(String placa, String modelo, String cor, Marca marca, Tipo tipo) {
    public Veiculo {
        if (placa == null || modelo == null || cor == null || marca == null || tipo == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }
        if (placa.length() != 7) { // Placa merco sul tem no minino 7 caracteres
            throw new IllegalArgumentException("A placa deve ter 7 caracteres.");
        }
        if (!placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) { // Exemplo de como a placa merco sul é ABC1D23
            throw new IllegalArgumentException("A placa deve estar no formato Mercosul (ex: ABC1D23).");
        }
    }

    public double getTarifa() {
        return tipo.getTarifa();
    }
    
}
