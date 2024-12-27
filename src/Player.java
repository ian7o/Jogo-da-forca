import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private int life = 6;
    private int points = 0;
    String name;

    public Player(String name) throws IOException {
        this.name = name;
    }

    public String enterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String input = reader.readLine();
        return input;
    }

    public String getUserInput = enterInput();



}
