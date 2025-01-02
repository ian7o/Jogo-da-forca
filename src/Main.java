import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Vamos jogar jogo da forca");
        System.out.println();
        System.out.println("jogador 1 escreva a palavra: ");
        //jogo registra a palavra
        Player player = new Player();
        Game game = new Game(player.writeTheWord(), player);
        //jogador 2 escreve uma letra e jogo faz a comparação
        System.out.println("jogador 2 escreva a primeira letra: ");
        game.playGame();
        game.showPlayerStatus();
    }
}
