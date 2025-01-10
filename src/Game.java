import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String word;
    private Player player = new Player();

    public void startGame() throws IOException {
        System.out.println("Jogo da forca vai começar");
        System.out.println();
        System.out.println("Escolha uma opção de jogo:");
        System.out.println("Opção 1: Jogador versus Jogador");
        System.out.println("Opção 2: Jogador versus Computador");
        System.out.println("Opção 3: Sair do jogo");
        System.out.println();

        player.playerChoseGameMode();

        switch (player.getChoseOption()) {
            case "1":
                player.clearConsole();

                System.out.println("jogador 1 escreva a palavra: ");
                //jogo registra a palavra
                word = player.writeTheWord();

                player.clearConsole();

                //jogador 2 escreve uma letra e jogo faz a comparação
                playGame(player);
                showPlayerStatus(word,player);
                displayGameWordState(secreteGameWordState);
                break;

            case "2":
                player.clearConsole();

                ReadLines readLine = new ReadLines();

                //o jogo escolhe uma palavra aleatoria de um ficheiro
                word = readLine.readARandomLine();

                playGame(player);
                showPlayerStatus(word,player);
                displayGameWordState(secreteGameWordState);
                break;

            case "3":
                System.out.println("Saindo");
                System.exit(1);
                player.clearConsole();
                break;

            default:

                System.out.println("Essa opção é inválida, escolha outra: ");
                startGame();
        }
    }

    public int countWordWithoutSpacesOrSpecialCaracter(String word) {
        int letterCounter = word.length();

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))) {
                letterCounter--;
            }
        }
        return letterCounter;
    }

    private List<String> registeredPlayerLetters = new ArrayList<>();

    private List<String> secreteGameWordState = new ArrayList<>();


    public void prepareSecreteWord(List<String> hangmanGame) {
        for (int i = 0; i < word.length(); i++) {
            hangmanGame.add("_");
        }
    }

    public void replaceSpacesAndHyphensIntoSpaces(String word, List<String> hangmanGame) {
        // Substitui espaços e traços por espaços
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ' || word.charAt(i) == '-') {
                hangmanGame.set(i, " ");
            }
        }
    }

    public void displayGameWordState(List<String> hangmanGame) {
        System.out.print("A palavra é: ");
        hangmanGame.forEach(s -> System.out.print(s));
        //imprime o bonequinho
        DrawHanged drawHanged = new DrawHanged();
        System.out.println();
        System.out.println();
        drawHanged.DrawHanged(player);
    }

    public boolean isNewLetter(Player player){
        //verificar se a letra já foi registrada
        if (registeredPlayerLetters.contains(player.getPlayerLetter())) {
            System.out.println("Já tentou com esta letra tenta outra letra");
            System.out.println();
            return false;
        }
        else {
            registeredPlayerLetters.add(player.getPlayerLetter());
            return true;
        }
    }

    public void updateHangmanWithCorrectLetter(String word, Player player, List<String> hangmanGame){
        if (word.contains(player.getPlayerLetter())) {
            System.out.println("Tem a letra na palavra");
            // vai em posição em posição e verifica se a letra digitada é igual a letra da palavra
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
            System.out.println("Nao tem a letra na palavra");
        }
    }

    public void playGame(Player player) {

        prepareSecreteWord(secreteGameWordState);

        while (player.getLife() > 0 && player.getCorrectLettersQuantity() < countWordWithoutSpacesOrSpecialCaracter(word)) {

            replaceSpacesAndHyphensIntoSpaces(word, secreteGameWordState);

            //Escreve se ainda não tiver letras registradas
            if (registeredPlayerLetters.isEmpty()) {
                System.out.println("Escreva a primeira letra:");
                displayGameWordState(secreteGameWordState);
            } else {
                System.out.println();
                System.out.println("Escreva outra letra:");
                displayGameWordState(secreteGameWordState);
            }

            player.playerEnterInput();

            if (isNewLetter(player)){
                updateHangmanWithCorrectLetter(word,player,secreteGameWordState);
                System.out.println();
                System.out.println();
            }
        }

    }

    public void showPlayerStatus(String word, Player player) {
        // Para mostrar as estátisticas do jogador
        System.out.println();

        if (player.getCorrectLettersQuantity() < 2) {
            System.out.println("Você acertou: " + player.getCorrectLettersQuantity() + " letra de um total de " + countWordWithoutSpacesOrSpecialCaracter(word));
        } else {
            System.out.println("Você acertou: " + player.getCorrectLettersQuantity() + " letras de um total de " + countWordWithoutSpacesOrSpecialCaracter(word));
        }

        if (player.getCorrectLettersQuantity() == countWordWithoutSpacesOrSpecialCaracter(word)) {
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
