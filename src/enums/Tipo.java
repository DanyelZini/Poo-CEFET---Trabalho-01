package enums;

public enum Tipo {
    CARRO(10.0),
    MOTO(5.0),
    UNITARIO(5.0);

    private double tarifa;

    Tipo(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double novaTarifa) {
        this.tarifa = novaTarifa;
    }

    public static Tipo valueOfIgnoreCase(String name) {
        for (Tipo tipo : values()) {
            if (tipo.name().equalsIgnoreCase(name)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nao ah " + name);
    }
}
