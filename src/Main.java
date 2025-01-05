import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Vamos jogar jogo da forca");
        System.out.println();
        Player player = new Player();
        System.out.println("escolha uma opção de jogo:");
        System.out.println("Opção 1: Jogador versus Jogador");
        System.out.println("Opção 2: Jogador versus computador");

        player.playerChoseGameMode();

        //colocar em um metodo em player se não não funciona
        switch (player.getChoseOption()) {
            case "1":
                player.clearConsole();

                System.out.println("jogador 1 escreva a palavra: ");

                //jogo registra a palavra
                Game game = new Game(player.writeTheWord(), player);

                player.clearConsole();


                //jogador 2 escreve uma letra e jogo faz a comparação
                System.out.println("jogador 2 escreva a primeira letra: ");
                game.playGame(player);
                game.showPlayerStatus(player);
                break;

            case "2":
                player.clearConsole();

                ReadLine readLine = new ReadLine();
                //o jogo escolhe uma palavra aleatoria de um ficheiro
                Game game2 = new Game(readLine.readASpecificLine(),player);


                System.out.println("jogador 2 escreva a primeira letra: ");
                game2.playGame(player);
                game2.showPlayerStatus(player);
                break;

            default:
                System.out.println("está opção é invalida escolha outra");
                player.playerChoseGameMode();
        }

    }
}
