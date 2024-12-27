import java.io.IOException;

public class Game {
    String palavra;
    public Game(String palavra) throws IOException {
        this.palavra=palavra;
    }
    Player player = new Player();

    public void compare() throws IOException {
        String letra = player.enterInput();
    }

}
