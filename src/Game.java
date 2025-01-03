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

        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != player.getWordSize()) {
            //escreve apenas se a lista não estiver vazia
            if (!registeredLetters.isEmpty()) {
                System.out.println("Escreva outra letra:");
            }
            player.playerEnterInput();

            //se a letra já foi registrada
            if (registeredLetters.contains(player.getPlayerLetter())) {
                System.out.println("Já tentou com esta letra tenta outra letra");
                System.out.println();
            } else {
                //primeiro adiciona a letra para a lista de letras registradas
                registeredLetters.add(player.getPlayerLetter());

                // se a letra do player conter na palavra
                if (word.contains(player.getPlayerLetter())) {
                    System.out.println();
                    System.out.println("Tem a letra na palavra");
                    // vai em posição em posição e verifica se a letra digitada é igual a palavra
                    for (int i = 0; i < word.length(); i++) {
                        // se a palavra conter um espaço substitui o traço por um espaço
                        if (word.charAt(i) == ' ') {
                            hangmanGame.set(i, " ");

                        }
                        // se a letra da palavra for igual a letra do jogador substitui o - pela a letra no espaço correto
                        if (word.charAt(i) == player.getPlayerLetter().charAt(0)) {
                            hangmanGame.set(i, player.getPlayerLetter());
                            player.increaseCorrectLettersQuantity();
                        }
                    }
                } else {
                    // se nao contem a letra na palvra
                    player.decreaseLife();
                    System.out.println("Nao tem a letra na palavra");
                    System.out.println("A vida está em :" + player.getLife());
                    System.out.println();
                }
                //imprimindo a forca
                System.out.print("A palavra é ");
                hangmanGame.forEach(i -> System.out.print(i));
                System.out.println();
            }
        }
    }

    public void showPlayerStatus() {
        System.out.println("Acertou:" + player.getCorrectLettersQuantity() + " letras de " + player.getWordSize());
        // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
        if (player.getCorrectLettersQuantity() == player.getWordSize()) {
            System.out.println("O jogador 2 venceu!!!");
        }
        // se a vida do jogador for 0 ele perde
        if (player.getLife() == 0) {
            System.out.println("Jogador 2 foi enforcado");
        }
    }
}