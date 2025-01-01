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
        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != word.length()) {
            player.playerEnterInput();

            //se a letra já foi registrada
            if (registeredLetters.contains(player.getPlayerLetter())) {
                System.out.println("já tentou com esta letra tenta outra letra");
            } else {

                //se for espaço vazio (enter)
                if (player.getPlayerLetter().isEmpty()) {
                    System.out.println("tem que escrever alguma letra");
                } else {
                    //primeiro adiciona a letra para a lista de letras registradas
                    registeredLetters.add(player.getPlayerLetter());
                    // se a letra que do player conter na palavra
                    if (word.contains(player.getPlayerLetter())) {
                        // vai em posição em posição verifica se a letra digitada é igual a palavra

                        for (int i = 0; i < word.length(); i++) {
                            // se for igual substitui o - pela a palavra
                            if (word.charAt(i) == player.getPlayerLetter().charAt(0)) {
                                hangmanGame.set(i, player.getPlayerLetter());
                                player.increaseCorrectLettersQuantity();
                            }
                        }
                        // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
                        if (player.getCorrectLettersQuantity() == word.length()) {
                            System.out.println();
                            System.out.println("o jogador 2 venceu!!!");
                        }

                    } else {
                        // se nao contem a letra na palvra
                        player.decreaseLife();
                        System.out.println("nao tem a letra na palavra");
                        System.out.println("a vida está em :" + player.getLife());
                        // se a vida do jogador for 0 ele perde
                        if (player.getLife() == 0) {
                            System.out.println("jogador 2 perdeu");
                        }
                    }
                    System.out.println();
                    System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
                    //imprimindo a forca
                    System.out.println(hangmanGame);
                }
            }
        }
    }
// estou com duvida se é melor dividir para o metodo nao ficar muito grande

//    public void showGameStatus() {
//    System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
//        if (player.getCorrectLettersQuantity() == word.length()) {
//            System.out.println("o jogador 2 venceu!!!");
//        }
//        if (player.getLife() == 0) {
//            System.out.println("jogador 2 perdeu");
//        }
//          System.out.println(hangmanGame);
//    }
}
