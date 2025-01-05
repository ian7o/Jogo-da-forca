import java.io.*;
import java.nio.file.Files;

public class ReadLine {

    private File wordsFile = new File("/Users/admin.ian.swerts/Jogo da forca ian/Words/Words.rtf");

    private File tipsFile = new File("/Users/admin.ian.swerts/Jogo da forca ian/Words/tipsDraft");

    public ReadLine() throws IOException {

    }

    private int getNumbersOfLinesInFile = Files.readAllLines(wordsFile.toPath()).size();

    private int randomLine = (int) (Math.random() * getNumbersOfLinesInFile);

    String ChosenLineOfWordsFile;
    String ChosenLineOfTipsFile;

    public String readASpecificLine() throws IOException {
        ChosenLineOfWordsFile = Files.readAllLines(wordsFile.toPath()).get(randomLine);
        ChosenLineOfTipsFile = Files.readAllLines(tipsFile.toPath()).get(randomLine);

        System.out.println(ChosenLineOfTipsFile);
        return ChosenLineOfWordsFile.toLowerCase();
    }

    private int wordSizeWithoutSpaces;

    public int getWordSizeWithoutSpaces() {
        return wordSizeWithoutSpaces;
    }

    public int countWordWithoutSpacesOrSpecialCaracter() {
        wordSizeWithoutSpaces = ChosenLineOfWordsFile.length();
        for (int i = 0; i < ChosenLineOfWordsFile.length(); i++) {
            if (!Character.isLetterOrDigit(ChosenLineOfWordsFile.charAt(i))) {
                wordSizeWithoutSpaces--;
            }
        }
        return wordSizeWithoutSpaces;
    }
}
