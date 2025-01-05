import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private String word;

    public String writeTheWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        word = reader.readLine().toLowerCase();

        //se for espaço vazio (enter)
        if (word.trim().isEmpty()) {
            System.out.println("Tem que escrever alguma palavra");
            writeTheWord();
        }

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) && !Character.isSpaceChar(word.charAt(i))) {
                System.out.println("Esse caractere não foi aceito escreva outro ");
                writeTheWord();
            }
        }

        return word.trim();
    }

    public void clearConsole(){
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

    public String playerEnterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //se for espaço vazio (enter)
        letter = reader.readLine().toLowerCase();

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

    public String getPlayerLetter() {
        return letter;
    }

    private String choseOption;

    public String getChoseOption() {
        return choseOption;
    }

    public String playerChoseGameMode() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //se for espaço vazio (enter)
        choseOption = reader.readLine().toLowerCase();

        if (choseOption.trim().isEmpty()) {
            System.out.println("tem que escrever alguma opção");
            playerChoseGameMode();
        }

        if (!Character.isDigit(choseOption.charAt(0))){
            System.out.println("Esse caractere não foi aceito escreva outro");
            playerChoseGameMode();
        }
        return choseOption;
    }
}