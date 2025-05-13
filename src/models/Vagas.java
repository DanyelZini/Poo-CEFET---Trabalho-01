package models;

import enums.Tipo;

public class Vagas {
    private int id;
    private String placaCarro;
    private Tipo tipo;
    private int piso;
    private boolean ocupado;

    public Vagas(int id, String placaCarro, Tipo tipo, int piso, boolean ocupado) {
        if (id <= 0) 
            throw new IllegalArgumentException("O id deve ser maior que 0.");
        if (placaCarro == null || placaCarro.isEmpty())
            throw new NullPointerException("A placa do carro não pode ser nula ou vazia.");
        if (piso < 0)
            throw new IllegalArgumentException("O piso deve ser maior ou igual a 0.");
        if (piso < 0)
            throw new IllegalArgumentException("O piso deve ser maior ou igual a 0.");
        if (ocupado == true)
            throw new NullPointerException("O status de ocupado não pode ser true de inicio.");

        this.id = id;
        this.placaCarro = placaCarro;
        this.tipo = tipo;
        this.piso = piso;
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id deve ser maior que 0.");
        }
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        if (piso < 0) {
            throw new IllegalArgumentException("O piso deve ser maior ou igual a 0.");
        }
        this.piso = piso;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        if (placaCarro == null || placaCarro.isEmpty()) {
            throw new NullPointerException("A placa do carro não pode ser nula ou vazia.");
        }
        this.placaCarro = placaCarro;
    }
}
