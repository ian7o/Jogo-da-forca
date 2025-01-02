import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    String word;
    Player player;

    public Game(String word, Player player) throws IOException {
        this.word = word;
        this.player = player;
    }

    List<String> registeredLetters = new ArrayList<>();
    List<String> hangmanGame = new ArrayList<>();

    public void fillSercretWord() {
        for (int i = 0; i < word.length(); i++) {
            hangmanGame.add("-");
        }
    }

    public void playGame() throws IOException {
        fillSercretWord();
        //enquanto o jogador estiver vivo ou não acertar todas as letras da palavra o jogo continua
        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != word.length()) {
            //escreve apenas se a lista não estiver vazia
            if (!registeredLetters.isEmpty()) {
                System.out.println("escreva outra letra:");
            }
            player.playerEnterInput();

            //se a letra já foi registrada
            if (registeredLetters.contains(player.getPlayerLetter())) {
                System.out.println("já tentou com esta letra tenta outra letra");
                System.out.println();
            } else {
                //primeiro adiciona a letra para a lista de letras registradas
                registeredLetters.add(player.getPlayerLetter());
                // se a letra que do player conter na palavra

                if (word.contains(player.getPlayerLetter())) {
                    System.out.println("tem a letra na palavra");
                    // vai em posição em posição e verifica se a letra digitada é igual a palavra
                    for (int i = 0; i < word.length(); i++) {
                        // se a letra da palavra for igual a letra do jogador substitui o - pela a letra no espaço correto
                        if (word.charAt(i) == player.getPlayerLetter().charAt(0)) {
                            hangmanGame.set(i, player.getPlayerLetter());
                            player.increaseCorrectLettersQuantity();
                        }
                    }
                } else {
                    // se nao contem a letra na palvra
                    player.decreaseLife();
                    System.out.println("nao tem a letra na palavra");
                    System.out.println("a vida está em :" + player.getLife());
                    System.out.println();
                }
                //imprimindo a forca
                System.out.println(hangmanGame);
                System.out.println();
            }
        }
    }

    public void showPlayerStatus() {
        System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
        // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
        if (player.getCorrectLettersQuantity() == word.length()) {
            System.out.println("o jogador 2 venceu!!!");
        }
        // se a vida do jogador for 0 ele perde
        if (player.getLife() == 0) {
            System.out.println("jogador 2 foi enforcado");
        }
    }
}