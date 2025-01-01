import java.io.*;

public class GetWord {
    private String word;

    public String writeTheWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        word = reader.readLine().toLowerCase();
        if (word.isEmpty()) {
            System.out.println("tem que escrever alguma palavra");
            writeTheWord();
        }
        return word;
    }

}