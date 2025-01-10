import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
ReadLines readLines = new ReadLines();
readLines.readARandomLine();
Game game = new Game();
game.startGame();
    }
}