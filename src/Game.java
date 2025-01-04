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
            hangmanGame.add("-");
        }
    }

    public void playGame(Player player) throws IOException {
        PrepareSecreteWord(secreteGameWordState);

        //se a opção escolhida for jogar contra outro jogador
        switch (player.getChoseOption()) {
            case "1":
                //enquanto o jogador estiver vivo ou não acertar todas as letras da palavra o jogo continua
                while (player.getLife() != 0 && player.getCorrectLettersQuantity() != player.getWordSizeWithoutSpaces()) {
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
                                if (!Character.isLetter(word.charAt(i))) {
                                    secreteGameWordState.set(i, " ");
                                }

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

                break;
            //caso o jogador escolha jogar contra o computador
            case "2":

                while (player.getLife() != 0 && player.getCorrectLettersQuantity() != word.length()) {
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
                                if (!Character.isLetter(word.charAt(i))) {
                                    secreteGameWordState.set(i, " ");
                                }

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

                break;
        }

    }

    public void showPlayerStatus(Player player) {
        switch (player.getChoseOption()){
            case "1":
                // mudar para a palavra
                System.out.println("Acertou:" + player.getCorrectLettersQuantity() + " letras de " + player.getWordSizeWithoutSpaces());
                // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
                if (player.getCorrectLettersQuantity() == player.getWordSizeWithoutSpaces()) {
                    System.out.println("O jogador 2 venceu!!!");
                }
                // se a vida do jogador for 0 ele perde
                if (player.getLife() == 0) {
                    System.out.println("Jogador 2 foi enforcado");
                }
                break;

            case "2":
                // mudar para a palavra
                System.out.println("Acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
                // se a quantidade de letras corretas for igual ao tamanho da palavra o jogador vence
                if (player.getCorrectLettersQuantity() == player.getWordSizeWithoutSpaces()) {
                    System.out.println("O jogador 2 venceu!!!");
                }
                // se a vida do jogador for 0 ele perde
                if (player.getLife() == 0) {
                    System.out.println("Jogador 2 foi enforcado");
                    System.out.println("A palavra era " + word);
                }
                break;
        }
    }
}