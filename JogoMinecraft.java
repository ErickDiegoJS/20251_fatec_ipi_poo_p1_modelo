import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var alex = new JogadorMinecraft("Alex");

        var gerador = new Random();

        while(true){
            switch (gerador.nextInt(3)) {
                case 0:
                    alex.minerar();
                    System.out.println(alex.toString());
                    break;
                case 1:
                    alex.coletarMadeira();
                    System.out.println(alex.toString());
                    break;
                case 2:
                    alex.construir();
                    System.out.println(alex.toString());
                    break;
                default:
                    break;
            }
            System.out.println("\n============\n");
            Thread.sleep(5000);
        }
    }
}