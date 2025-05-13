import models.Veiculo;

public class App {
    public static void main() {
        try {
            Veiculo veiculo = new Veiculo("ABC1D2", "Fusca", "azul", enums.Marca.VOLKSWAGEN, enums.Tipo.CARRO);
            System.out.println(veiculo.toString());
            System.out.println("Tarifa: " + veiculo.getTarifa());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Um ou mais campos estão nulos.");
        }

        System.out.println("algo");
    }
}
