import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private int life = 6;
    private int points = 0;

    public int getLife() {
        return life;
    }

    public int decreaseLife() {
        return --life;
    }

    public int getLetersQuantity() {
        return points;
    }

    public int increasePoints() {
        return ++points;
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
