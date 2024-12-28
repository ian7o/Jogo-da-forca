import java.io.IOException;

public class Game {
    String palavra;

    public Game(String palavra) throws IOException {
        this.palavra = palavra;
    }

    Player player = new Player();

    public void compare() throws IOException {
        while (player.getLife() != 0 && player.getPoints() != palavra.length()) {
            player.enterInput();
            if (palavra.contains(player.letra)) {
                for (int i = 0; i < palavra.length(); i++) {
                    if (palavra.charAt(i) == player.letra.charAt(0)) {
                        //fins de teste
                        System.out.println("tem a letra");
                        player.increasePoints();
                    } else {
                        //fins de teste
                        System.out.println("nao tem a letra");
                    }
                }

                System.out.println("acertou:" + player.getPoints() + " letras de " + palavra.length());
            } else {
                player.decreaseLife();
                System.out.println("nao tem a letra");
                System.out.println("a vida está em :" + player.getLife());

            }

        }
    }
}
