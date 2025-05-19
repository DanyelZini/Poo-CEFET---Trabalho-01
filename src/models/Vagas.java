package models;

import java.sql.Date;

public class Vagas {
    private int id;
    private String placaCarro;
    private Date dataEntrada;
    private boolean ocupado;

    
    public Vagas(int id) {
        if (id < 0) 
            throw new IllegalArgumentException("Vagas: O id deve ser maior que 0.");
        if (ocupado == true)
            throw new IllegalArgumentException("Vagas: O status de ocupado não pode ser true de inicio.");

        this.id = id;
        this.placaCarro = null;
        this.ocupado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Vagas-setId: O id deve ser maior que 0.");
        }
        this.id = id;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        if (dataEntrada == null) {
            throw new NullPointerException("Vagas-setDataEntrada: A data de entrada não pode ser nula.");
        }
        this.dataEntrada = dataEntrada;
    }

    public void setPlacaCarro(String placaCarro) {
        if (placaCarro == null || placaCarro.isEmpty()) {
            throw new NullPointerException("Vagas-setPlacaCarro: A placa do carro não pode ser nula ou vazia.");
        }
        this.placaCarro = placaCarro;
    }

    public void limparVaga() {
        this.placaCarro = null;
        this.ocupado = false;
        this.dataEntrada = null;
    }

    public void ocuparVaga(String placaCarro) {
        if (placaCarro == null || placaCarro.isEmpty()) {
            throw new NullPointerException("Vagas-ocuparVaga: A placa do carro não pode ser nula ou vazia.");
        }
        this.placaCarro = placaCarro;
        this.dataEntrada = new Date(System.currentTimeMillis());
        this.ocupado = true;
    }


    @Override
    public String toString() {
        return "\t\t> [id=" + id + ", placaCarro=" + placaCarro + ", ocupado=" + ocupado + "]";
    }

    
}
