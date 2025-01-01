import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Vamos jogar jogo da forca");
        // jogador 1 escreve a palavra
        System.out.println("jogador 1 escreva a palavra: ");
        GetWord getWord = new GetWord();
        //jogo registra a palavra
        Player player = new Player();
        Game game = new Game(getWord.writeTheWord(), player);
        //jogador 2 escreve uma letra e jogo faz a comparação
        System.out.println("jogador 2 escreva uma letra: ");

        game.playGame();
    }
}
