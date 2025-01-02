import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private String word;

    public String writeTheWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        word = reader.readLine().toLowerCase();
        //se for espaço vazio (enter)
        if (word.isEmpty()) {
            System.out.println("tem que escrever alguma palavra");
            writeTheWord();
        }

        //se conter numeros
        if (word.contains("1") || word.contains("2") || word.contains("3") || word.contains("4") || word.contains("5") || word.contains("6") || word.contains("7") || word.contains("8") || word.contains("9") || word.contains("0")) {
            System.out.println("a palavra não pode conter numeros");
            writeTheWord();
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        return word;
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

    public Player() throws IOException {

    }

    private String letter;

    public String playerEnterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //se for espaço vazio (enter)
        letter = reader.readLine().toLowerCase();

        if (letter.isEmpty()){
            System.out.println("tem que escrever alguma letra");
            playerEnterInput();
        }
        if (letter.length()>1){
            System.out.println("escreva apenas uma letra");
            playerEnterInput();
        }
        return letter;
    }

    public String getPlayerLetter() {
        return letter;
    }
}