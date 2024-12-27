import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private int life = 6;
    private int points = 0;

    public int getLife() {
        return life;
    }

    public int decreaseLife(){
        return --life;
    }

    public int getPoints() {
        return points;
    }
    public int increasePoints(){
        return ++points;
    }

    public Player( ) throws IOException {

    }

    public String enterInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        return input;
    }
    public String getUserInput() throws IOException {
        return enterInput();
    }

}
