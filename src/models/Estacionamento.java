package models;

public class Estacionamento {
    private Vagas[][] vagas;
    private int quantPorPiso;
    private int quantPisos;
    private boolean cheia;

    public Estacionamento(int quantPorPiso, int quantPisos) {
        if (quantPisos <= 0) 
            throw new IllegalArgumentException("A quantidade de pisos deve ser maior que 0.");
        if (quantPorPiso <= 0) 
            throw new IllegalArgumentException("O total de vagas deve ser maior que 0.");
        
        this.quantPorPiso = quantPorPiso;
        this.quantPisos = quantPisos;
        this.vagas = new Vagas[quantPorPiso][quantPisos];
        this.cheia = false;
    }

    public Vagas[][] getVagas() {
        return vagas;
    }

    public void setVagas(Vagas[][] vagas) {
        this.vagas = vagas;
    }

    public int getQuantPorPiso() {
        return quantPorPiso;
    }

    public void setQuantPorPiso(int quantPorPiso) {
        if (quantPorPiso <= 0) 
            throw new IllegalArgumentException("O total de vagas deve ser maior que 0.");
        this.quantPorPiso = quantPorPiso;
    }

    public int getQuantPisos() {
        return quantPisos;
    }

    public void setQuantPisos(int quantPisos) {
        if (quantPisos <= 0) 
            throw new IllegalArgumentException("A quantidade de pisos deve ser maior que 0.");
        this.quantPisos = quantPisos;
    }

    public boolean isCheia() {
        return cheia;
    }

    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }
}
