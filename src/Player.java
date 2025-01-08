import java.util.Scanner;

public class Player {
    private String word;

    public void startGame(){
        System.out.println("Jogo da forca começa");
        System.out.println();
        System.out.println("Escolha uma opção de jogo:");
        System.out.println("Opção 1: Jogador versus Jogador");
        System.out.println("Opção 2: Jogador versus Computador");
    }

    public String writeTheWord() {
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine().toLowerCase();

        //Se for espaço vazio (enter)
        if (word.trim().isEmpty()) {
            System.out.println("Tem que escrever alguma palavra: ");
            writeTheWord();
        }

        // Verifica se há algum caractere não permitido (tudo que não seja letra ou espaço)
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) && !Character.isSpaceChar(word.charAt(i))) {
                System.out.println("Esse caractere " + word.charAt(i) + " não foi aceito. Por favor, escreva outra palavra:");
                writeTheWord();
            }
        }

        return word.trim();
    }

    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private int life = 6;

    private int correctLetters = 0;

    public int getLife() {
        return life;
    }

    public int decreaseLife() {
        return --life;
    }

    public int getCorrectLettersQuantity() {
        return correctLetters;
    }

    public int increaseCorrectLettersQuantity() {
        return ++correctLetters;
    }


    private String letter;

    public String getPlayerLetter() {
        return letter;
    }

    public String playerEnterInput() {
        Scanner scanner = new Scanner(System.in);

        //se for espaço vazio (enter)
        letter = scanner.nextLine().toLowerCase();

        if (letter.trim().isEmpty()) {
            System.out.println("tem que escrever alguma letra");
            playerEnterInput();
        }
        if (letter.length() > 1) {
            System.out.println("Escreva apenas uma letra");
            playerEnterInput();
        }
        return letter;
    }

    private String choseOption;

    public String getChoseOption() {
        return choseOption;
    }

    public String playerChoseGameMode() {

        Scanner scanner = new Scanner(System.in);

        //se for espaço vazio (enter)
        choseOption = scanner.nextLine().toLowerCase().trim();

        if (choseOption.isEmpty()) {
            System.out.println("Tem que escolher alguma opção");
            playerChoseGameMode();
        }

        if (!Character.isDigit(choseOption.charAt(0))) {
            System.out.println("Esse caractere " + choseOption.charAt(0) + " não foi aceito escreva outro");
            playerChoseGameMode();
        }
        return choseOption;
    }

}