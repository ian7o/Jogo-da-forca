import java.io.IOException;
public class IntializeGame {

public void prepereGame() throws IOException {
    Player player = new Player();
    player.startGame();
    player.playerChoseGameMode();

    switch (player.getChoseOption()) {
        case "1":
            player.clearConsole();

            System.out.println("jogador 1 escreva a palavra: ");
            //jogo registra a palavra
            Game game = new Game(player.writeTheWord(), player);

            player.clearConsole();

            //jogador 2 escreve uma letra e jogo faz a comparação
            game.playGame(player);
            game.showPlayerStatus(player);
            break;

        case "2":
            player.clearConsole();

            ReadLines readLine = new ReadLines();
            //o jogo escolhe uma palavra aleatoria de um ficheiro
            Game game2 = new Game(readLine.readASpecificLine(), player);

            System.out.println("jogador 2 escreva a primeira letra: ");
            game2.playGame(player);
            game2.showPlayerStatus(player);
            break;

        case "3":
            System.out.println("Saindo");
            System.exit(1);
            player.clearConsole();
            break;
        default:

            System.out.println("Essa opção é inválida, escolha outra: ");
            prepereGame();
    }
}
}
