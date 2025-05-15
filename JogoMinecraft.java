import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var alex = new JogadorMinecraft("Alex");

        var gerador = new Random();

        while (true) {
            if (gerador.nextInt(4) == 0) {
                alex.levarDano();
                if (!alex.estaVivo()) {
                    System.out.println("GAME OVER");
                    return;
                }
            }
            switch (gerador.nextInt(3)) {
                case 0:
                    alex.minerar();
                    break;
                case 1:
                    alex.coletarMadeira();
                    break;
                case 2:
                    alex.construir();
                    break;
                default:
                    break;
            }
            System.out.println(alex.toString());
            System.out.println("\n============\n");
            Thread.sleep(5000);
        }
    }
}