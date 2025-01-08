public class DrawHanged {

    // Imprime o bonequinho conforme o jogador erra a palavra
    public void DrawHanged(Player player) {

        switch (player.getLife()) {
            case 6:
                System.out.println("----|");
                break;

            case 5:
                System.out.println("----|");
                System.out.println("    o");
                break;

            case 4:
                System.out.println("----|");
                System.out.println("    o");
                System.out.println("    |");
                break;

            case 3:
                System.out.println("----|");
                System.out.println("    o");
                System.out.println("   /|");
                break;

            case 2:
                System.out.println("----|");
                System.out.println("    o");
                System.out.println("   /|\\");
                break;

            case 1:
                System.out.println("----|");
                System.out.println("    o");
                System.out.println("   /|\\");
                System.out.println("   /");
                break;

            case 0:
                System.out.println("----|");
                System.out.println("    o");
                System.out.println("   /|\\");
                System.out.println("   / \\");
                break;
        }
    }
}