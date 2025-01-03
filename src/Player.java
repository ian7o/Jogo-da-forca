import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private String word;

    //    private int wordLength = word.length();
    public String getWord() {
        return word;
    }

    // tenho que so mudar em player na parte de vencer

    public String writeTheWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        word = reader.readLine().toLowerCase();
        // armazenar o tamnho em um int
        // se tiver espaço diminuir esse int
        // la no outro metodo primeiro verifica se é um espaço se for so substititui por um espaço

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
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        return word.trim();
    }

    private int wordSize;

    public int countSpace() {
        wordSize = word.length();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                wordSize--;
            }
        }
        return wordSize;
    }

    public int getWordSize() {
        return wordSize;
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

    public Player() {

    }

    private String letter;

    public String playerEnterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //se for espaço vazio (enter)
        letter = reader.readLine().toLowerCase();

        if (letter.isEmpty()) {
            System.out.println("tem que escrever alguma letra");
            playerEnterInput();
        }
        if (letter.length() > 1) {
            System.out.println("escreva apenas uma letra");
            playerEnterInput();
        }
        return letter;
    }

    public String getPlayerLetter() {
        return letter;
    }
}