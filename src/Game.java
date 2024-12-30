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

    public void playGame() throws IOException {
        while (player.getLife() != 0 && player.getCorrectLettersQuantity() != word.length()) {
            player.enterInput();
            //se contem na lista

            if (registeredLetters.contains(player.getLetra())) {
                System.out.println("já tentou com esta letra tenta outra letra");
            } else {
                //nao adciona na lista se for uma letra vazia (enter)
                if (!player.getLetra().isEmpty()){
                registeredLetters.add(player.getLetra());
                }
                if (word.contains(player.getLetra())) {
                    for (int i = 0; i < word.length(); i++) {
                        //se nao escreveu nada
                        if (player.getLetra().isEmpty()){
                            System.out.println("tem que escrever alguma coisa");
                            break;
                        }
                        else if (word.charAt(i) == player.getLetra().charAt(0)) {
                            //fins de teste
                            System.out.println("tem a letra na palavra");
                            player.increaseCorrectLettersQuantity();

                        } else {
                            //fins de teste
                            System.out.println("nao tem a letra na palavra");
                        }
                    }

                    if (player.getCorrectLettersQuantity() == word.length()) {
                        System.out.println();
                        System.out.println("o jogador 2 venceu!!!");
                    }
                    System.out.println("acertou:" + player.getCorrectLettersQuantity() + " letras de " + word.length());
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
