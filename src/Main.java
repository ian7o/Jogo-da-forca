import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("jogador 1 escreva a palavra: ");
        GetWord getWord = new GetWord();
        Game game = new Game(getWord.WriteTheWord());
        System.out.println("jogador 2 escreva uma letra: ");
        game.compare();
    }
}
