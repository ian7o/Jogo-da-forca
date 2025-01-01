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

    private String Letter;

    public String playerEnterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Letter = reader.readLine().toLowerCase();
        return Letter;
    }

    public String getPlayerLetter() {
        return Letter;
    }
}
