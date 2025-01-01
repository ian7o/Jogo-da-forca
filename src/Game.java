import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    String word;
    Player player = new Player();

    public Game(String word) throws IOException {
        this.word = word;
    }

    List<String> registeredLetters = new ArrayList<>();
    List<String> replaceforWordsList = new ArrayList<>();

    public void fillSercretWord (){
        for (int i = 0; i < word.length(); i++) {
            replaceforWordsList.add("-");
        }
    }
    public void playGame() throws IOException {
        fillSercretWord();
        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != word.length()) {
            player.playerEnterInput();

            //se contem na lista
            if (registeredLetters.contains(player.getPlayerLetter())) {
                System.out.println("já tentou com esta letra tenta outra letra");
            } else {
                //se nao escreveu nada
                if (player.getPlayerLetter().isEmpty()) {
                    System.out.println("tem que escrever alguma coisa");
                } else {
                    registeredLetters.add(player.getPlayerLetter());
                    if (word.contains(player.getPlayerLetter())) {
                        for (int i = 0; i < word.length(); i++) {
                            if (word.charAt(i) == player.getPlayerLetter().charAt(0)) {
                                //fins de teste


                                replaceforWordsList.set(i, player.getPlayerLetter());
                                player.increaseCorrectLettersQuantity();

                            }
                        }

                        if (player.getCorrectLettersQuantity() == word.length()) {
                            System.out.println();
                            System.out.println("o jogador 2 venceu!!!");
                        }
                        System.out.println();
                        System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());

                        //imprimindo a forca
                        System.out.println(replaceforWordsList);
                    } else {
                        player.decreaseLife();
                        System.out.println("nao tem a letra");
                        System.out.println("a vida está em :" + player.getLife());

                        if (player.getLife() == 0) {
                            System.out.println("jogador 2 perdeu");
                        }
                    }
                }
            }
        }
    }
// estou com duvida se é melor dividir para o metodo nao ficar muito grande

//    public void showGameStatus() {
//    System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
//        if (player.getCorrectLettersQuantity() == word.length()) {
//            System.out.println("o jogador 2 venceu!!!");
//        }
//        if (player.getLife() == 0) {
//            System.out.println("jogador 2 perdeu");
//        }
//    }
}
