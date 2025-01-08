import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String word;
    private Player player;

    public Game(String word, Player player) {
        this.word = word;
        this.player = player;
    }

    private List<String> registeredLetters = new ArrayList<>();

    private List<String> secreteGameWordState = new ArrayList<>();

    public List<String> getSecreteGameWordState() {
        return secreteGameWordState;
    }

    public void prepareSecreteWord(List<String> hangmanGame) {
        for (int i = 0; i < word.length(); i++) {
            hangmanGame.add("_");
        }
    }

    CountLetterClass countHelper = new CountLetterClass();

    public void playGame(Player player) {

        prepareSecreteWord(secreteGameWordState);

        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != countHelper.countWordWithoutSpacesOrSpecialCaracter(word)) {

            //Se a palavra tiver espaços ou um caractere especial
            for (int i = 0; i < word.length(); i++) {
                // se a palavra conter um espaço substitui o traço por um espaço
                if (!Character.isLetter(word.charAt(i))) {
                    secreteGameWordState.set(i, " ");
                }
            }

            //Escreve  se a lista não estiver vazia
            if (registeredLetters.isEmpty()){
                System.out.println("Escreva a primeira letra");
                System.out.print("A palavra é: ");
                getSecreteGameWordState().forEach(s -> System.out.print(s));
            }
            else  {
                System.out.println();
                System.out.println("Escreva outra letra:");
                System.out.print("A palavra é: ");
                getSecreteGameWordState().forEach(s -> System.out.print(s));
                //imprime o bonequinho
                DrawHanged drawHanged = new DrawHanged();
                System.out.println();
                System.out.println();
                drawHanged.DrawHanged(player);
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
                }
                //imprimindo a forca
                System.out.println();
//                System.out.print("A palavra é ");
//                secreteGameWordState.forEach(System.out::print);
                System.out.println();
            }
        }


    }

    public void showPlayerStatus(Player player) {
        // Para mostrar as estátisticas
        System.out.println();

        if (player.getCorrectLettersQuantity()<2){
            System.out.println("Você acertou: " + player.getCorrectLettersQuantity() + " letra de um total de " + countHelper.countWordWithoutSpacesOrSpecialCaracter(word));
        }
        else {
        System.out.println("Você acertou: " + player.getCorrectLettersQuantity() + " letras de um total de " + countHelper.countWordWithoutSpacesOrSpecialCaracter(word));
        }

        if (player.getCorrectLettersQuantity() == countHelper.countWordWithoutSpacesOrSpecialCaracter(word)) {
            System.out.println("O jogador 2 venceu!!!");
        }

        // se a vida do jogador for 0 ele perde
        if (player.getLife() == 0) {
            System.out.println("Jogador 2 foi enforcado");
            System.out.println("A palavra era " + word);

            //Imprimindo o bonequinho
            DrawHanged drawHanged = new DrawHanged();
            drawHanged.DrawHanged(player);
        }
    }
}
