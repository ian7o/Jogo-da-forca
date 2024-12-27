import java.io.*;
import java.nio.file.Files;

public class ReadLine {

    private File file = new File("/Users/admin.ian.swerts/Jogo da forca ian/Words/Words.rtf");

    public ReadLine() throws IOException {

    }

    private int getNumbersOfLinesInFile = Files.readAllLines(file.toPath()).size();

    public int getRandomLine() {
        int randomLine = (int) (Math.random() * getNumbersOfLinesInFile);
        return randomLine;
    }

    public String readASpecificLine() throws IOException {
        String chosenLine = Files.readAllLines(file.toPath()).get(getRandomLine());
        return chosenLine;
    }

}
