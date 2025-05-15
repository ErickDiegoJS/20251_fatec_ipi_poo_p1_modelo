import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var alex = new JogadorMinecraft("Alex");
        var steve = new JogadorMinecraft("Steve Construtor");

        var gerador = new Random();
        boolean vitoriaAnunciada = false;
        while (true) {
            if(steve.estaVivo() && alex.estaVivo()){
                if(gerador.nextBoolean()){
                    System.out.println("Steve atacou Alex");
                    alex.levarDano();
                }
                else{
                    System.out.println("Alex atacou Steve");
                    steve.levarDano();
                }
            }

            if (alex.estaVivo()) {
                tomarAcaoAleatoria(gerador, alex, new int[] { 1, 1, 1 });
                if (gerador.nextInt(4) == 0) {
                    alex.levarDano();
                }
                System.out.println(alex.toString());
            }
            if (steve.estaVivo()) {
                tomarAcaoAleatoria(gerador, steve, new int[] { 1, 3, 6 });
                if (gerador.nextInt(4) == 0) {
                    steve.levarDano();
                }
                System.out.println(steve.toString());
            }

            if(!steve.estaVivo() && alex.estaVivo() && !vitoriaAnunciada){
                System.out.println("Alex venceu");
                vitoriaAnunciada = true;
            } else if (steve.estaVivo() && !alex.estaVivo() && !vitoriaAnunciada){
                System.out.println("Steve venceu");
                vitoriaAnunciada = true;
            }

            if(!steve.estaVivo() && !alex.estaVivo()){
                System.out.println("GAME OVER");
                return;
            }
            System.out.println("\n============\n");
            Thread.sleep(5000);
        }
    }

    public static void tomarAcaoAleatoria(Random gerador, JogadorMinecraft jogador, int[] pesos) {
        int total = 0;

        for (int i = 0; i < pesos.length; i++) {
            total += pesos[i];
        }

        int valorSorteado = gerador.nextInt(total);
        if (valorSorteado < pesos[0]) {
            jogador.minerar();
        } else if (valorSorteado < pesos[0] + pesos[1]) {
            jogador.coletarMadeira();
        } else if (valorSorteado < pesos[0] + pesos[1] + pesos[2]) {
            jogador.construir();
        }
    }
}