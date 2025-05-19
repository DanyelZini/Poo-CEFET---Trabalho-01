package models;

import java.sql.Date;

import enums.Tipo;

public class Estacionamento {
    private Vagas[] vagas;
    private int quantPorPiso;
    private int quantPisos;
    private boolean cheia;

    public Estacionamento(int quantPorPiso, int quantPisos) {
        if (quantPisos <= 0)
            throw new IllegalArgumentException("Estacionamento: A quantidade de pisos deve ser maior que 0.");
        if (quantPorPiso <= 0)
            throw new IllegalArgumentException("Estacionamento: O total de vagas deve ser maior que 0.");

        this.quantPorPiso = quantPorPiso;
        this.quantPisos = quantPisos;
        this.vagas = new Vagas[quantPorPiso * quantPisos];

        for (int j = 0; j < vagas.length; j++) {
            this.vagas[j] = new Vagas(j);
        }

        this.cheia = false;
    }

    public Vagas[] getVagas() {
        return vagas;
    }

    public void setVaga(String placa) {
        for(int i = 0; i < vagas.length; i++) {
            if (vagas[i].getPlacaCarro() != null && vagas[i].getPlacaCarro().equals(placa)) {
                throw new IllegalArgumentException("Estacionamento-setVaga: Veículo já estacionado.");
            }
        }
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i].getPlacaCarro() == null) {
                vagas[i].ocuparVaga(placa);
                return;
            }
        }
    }

    public Date limparVaga(String placa) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i].getPlacaCarro() != null && vagas[i].getPlacaCarro().equals(placa)) {
                Date dataSaida = new Date(System.currentTimeMillis());
                vagas[i].limparVaga();
                return dataSaida;
            }
        }
        throw new IllegalArgumentException("Estacionamento-limparVaga: Veículo não encontrado.");
    }

    public int getQuantPorPiso() {
        return quantPorPiso;
    }

    public void setQuantPorPiso(int quantPorPiso) {
        if (quantPorPiso <= 0)
            throw new IllegalArgumentException(
                    "Estacionamento-setQuantPorPiso: O total de vagas deve ser maior que 0.");
        this.quantPorPiso = quantPorPiso;
    }

    public int getQuantPisos() {
        return quantPisos;
    }

    public void setQuantPisos(int quantPisos) {
        if (quantPisos <= 0)
            throw new IllegalArgumentException(
                    "Estacionamento-setQuantPisos:  A quantidade de pisos deve ser maior que 0.");
        this.quantPisos = quantPisos;
    }

    public boolean isCheia() {
        return cheia;
    }

    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }

    private String vagasToString() {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < vagas.length; j++) {
            sb.append(vagas[j].toString()).append("\n");
        }

        return sb.toString();
    }

    public String toString() {
        return "Estacionamento [quantPorPiso=" + quantPorPiso + ", quantPisos=" + quantPisos + ", cheia=" + cheia
                + ".\n\t Vagas:\n" +
                this.vagasToString()
                + "\n]";
    }

    public Double calcularTarifa(String tipo, Date datasaida) {
        Tipo Tarifas = Tipo.valueOfIgnoreCase(tipo);
        double tarifa = Tarifas.getTarifa();
        long tempoEstacionado = datasaida.getTime() - System.currentTimeMillis();
        long horasEstacionado = tempoEstacionado / (1000 * 60 * 60);
        if (horasEstacionado <= 0) {
            throw new IllegalArgumentException("Estacionamento-calcularTarifa: O veiculo nao esta estacionado.");
        }
        if (horasEstacionado > 24) {
            throw new IllegalArgumentException("Estacionamento-calcularTarifa: O veiculo esta estacionado ha mais de 24 horas.");
        }
        if (horasEstacionado <= 1) {
            return tarifa;
        } else {
            return tarifa + (horasEstacionado - 1) * (tarifa / 2);
        }
    }

}
