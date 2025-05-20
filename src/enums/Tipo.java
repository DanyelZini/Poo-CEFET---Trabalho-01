package enums;

public enum Tipo {
    CARRO(10.0),
    MOTO(5.0),
    UNITARIO(5.0);

    private double tarifa;

    Tipo(double tarifa) {
        this.tarifa = tarifa;
    }

    // public void modificarTarifa(Tipo tipo, double novaTarifa) {
    //     if (tipo == null) {
    //         throw new NullPointerException("Tipo-modificarTarifa: O tipo nao pode ser nulo.");
    //     }
    //     if (novaTarifa <= 0) {
    //         throw new IllegalArgumentException("Tipo-modificarTarifa: A tarifa deve ser maior que 0.");
    //     }
    //     tipo.tarifa = novaTarifa;
    // }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double novaTarifa) {
        this.tarifa = novaTarifa;
    }

    public static void modificarTarifaPorNome(String nomeTipo, double novaTarifa) {
        Tipo tipo = valueOfIgnoreCase(nomeTipo);
        tipo.setTarifa(novaTarifa);
    }

    public static Tipo valueOfIgnoreCase(String nome) {
        for (Tipo tipo : values()) {
            if (tipo.name().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nao ah " + nome);
    }
}
