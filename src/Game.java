import java.io.IOException;


public class Game {
    String palavra;

    public Game(String palavra) throws IOException {
        this.palavra = palavra;
    }

    Player player = new Player();

    public void compare() throws IOException {
        while (player.getLife() != 0 && player.getPoints() != palavra.length()) {
            if (palavra.contains(player.getUserInput())) {

                System.out.println("tem");
                player.increasePoints();
                System.out.println("os pontos estão em :" + player.getPoints());
            } else {
                player.decreaseLife();
                System.out.println("nao tem nao");
                System.out.println("a vida está em :" + player.getLife());

            }
        }
    }
}
