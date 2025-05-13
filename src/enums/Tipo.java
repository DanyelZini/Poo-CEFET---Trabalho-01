package enums;

public enum Tipo {
    CARRO(10.0),
    MOTO(5.0),
    CAMINHAO(20.0),
    ONIBUS(15.0);

    private final double tarifa;

    Tipo(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }
}
