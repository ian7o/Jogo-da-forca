import java.io.*;

public class GetWord {
    public String WriteTheWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String input = reader.readLine();
        return input;
    }

}
