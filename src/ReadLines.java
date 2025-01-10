import java.io.*;
import java.nio.file.Files;

public class ReadLines {


    private File wordsAndTipsFile = new File("/Users/admin.ian.swerts/Jogo da forca ian/Words/WordAndTips.csv");

    public String readARandomLine() throws IOException {

        //Armazena as linhas do ficheiro
        long totalLines = Files.lines(wordsAndTipsFile.toPath()).count();

        //Escolhe uma linha aleatoria com base no tamanho das linhas
        int randomLine = (int) (Math.random() * totalLines);

        //È atribuido na variavel a linha escolhida inteira
        String chosenLine = Files.readAllLines(wordsAndTipsFile.toPath()).get(randomLine);

        //A linha é separada em partes
        String[] parts = chosenLine.split(";");

        //A palavra é a primeira parte da frase
        String word = parts[0];

        //A dica é a segunda parte da frase
        String tip = parts[1];
        System.out.println("Dica da palavra: " + tip);

        return word.trim().toLowerCase();
    }
}