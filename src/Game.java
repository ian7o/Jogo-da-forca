import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    String word;
    Player player;

    public Game(String word, Player player) {
        this.word = word;
        this.player = player;
    }

    private List<String> registeredLetters = new ArrayList<>();

    private List<String> secreteGameWordState = new ArrayList<>();

    public void PrepareSecreteWord(List<String> hangmanGame) {
        for (int i = 0; i < word.length(); i++) {
            hangmanGame.add("_");
        }
    }

    CountHelper countHelper = new CountHelper();

    int lettersCount = 0;

    public void playGame(Player player) throws IOException {
        PrepareSecreteWord(secreteGameWordState);

        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != countHelper.countWordWithoutSpacesOrSpecialCaracter(word, lettersCount)) {
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

                for (int i = 0; i < word.length(); i++) {
                    // se a palavra conter um espaço substitui o traço por um espaço
                    if (!Character.isLetter(word.charAt(i))) {
                        secreteGameWordState.set(i, " ");
                    }
                }

                // se a letra do player conter na palavra
                if (word.contains(player.getPlayerLetter())) {
                    System.out.println();
                    System.out.println("Tem a letra na palavra");
                    // vai em posição em posição e verifica se a letra digitada é igual a palavra
                    for (int i = 0; i < word.length(); i++) {

                        // se a letra da palavra for igual a letra do jogador substitui o - pela a letra no espaço correto
                        if (word.charAt(i) == player.getPlayerLetter().charAt(0)) {
                            secreteGameWordState.set(i, player.getPlayerLetter());
                            player.increaseCorrectLettersQuantity();
                        }
                    }
                } else {
                    // se nao contem a letra na palvra
                    player.decreaseLife();
                    System.out.println("Nao tem a letra na palavra");
                    System.out.println("Vidas restantes:" + player.getLife());
                    System.out.println();
                }
                //imprimindo a forca
                System.out.print("A palavra é ");
                secreteGameWordState.forEach(i -> System.out.print(i));
                System.out.println();
            }
        }


    }

    public void showPlayerStatus(Player player) {
        // Para mostrar as estátisticas
        System.out.println("Acertou:" + player.getCorrectLettersQuantity() + " letras de " + countHelper.countWordWithoutSpacesOrSpecialCaracter(word, lettersCount));
        // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
        if (player.getCorrectLettersQuantity() == countHelper.countWordWithoutSpacesOrSpecialCaracter(word, lettersCount)) {
            System.out.println("O jogador 2 venceu!!!");
        }
        // se a vida do jogador for 0 ele perde
        if (player.getLife() == 0) {
            System.out.println("Jogador 2 foi enforcado");
            System.out.println("A palavra era " + word);
        }
    }
}