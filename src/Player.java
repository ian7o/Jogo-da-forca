import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
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
    private String letra;

    public String enterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        letra = reader.readLine();
        return letra;
    }

    public String getLetra() {
        return letra;
    }
}
