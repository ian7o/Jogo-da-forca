import java.io.IOException;

public class Game {
    String palavra;

    public Game(String palavra) throws IOException {
        this.palavra = palavra;
    }

    Player player = new Player();

    public void compare() throws IOException {
        while (player.getLife() != 0 && player.getLetersQuantity() != palavra.length()) {
            player.enterInput();
            if (palavra.contains(player.getLetra())) {
                for (int i = 0; i < palavra.length(); i++) {
                    if (palavra.charAt(i) == player.getLetra().charAt(0)) {
                        //fins de teste
                        System.out.println("tem a letra");
                        player.increasePoints();

                    } else {
                        //fins de teste
                        System.out.println("nao tem a letra");
                    }
                }

                System.out.println("acertou:" + player.getLetersQuantity() + " letras de " + palavra.length());
            } else {
                player.decreaseLife();
                System.out.println("nao tem a letra");
                System.out.println("a vida está em :" + player.getLife());

            }
        }
    }

    public void showWinnerOrLoser() {
        if (player.getLetersQuantity() == palavra.length()) {
            System.out.println("o jogador 2 venceu!!!");
        }
        if (player.getLife() == 0) {
            System.out.println("jogador 2 perdeu");
        }
    }
}
