import Controller.Atendimento;
import Controller.Gestao;

public class App {
    public static void main() {
        Atendimento atendimento = new Atendimento();
        Gestao gestao = new Gestao();

        atendimento.menu();

    }
}
