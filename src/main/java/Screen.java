public abstract class Screen {
    private static final int screenWidth = 128;
    private static final String cardIndent = " ".repeat((int) (screenWidth/2.6));
    private static final String gameTitle = " ~* Goblins and Glitches *~ ";
    private static final String subTitle = "-- Revenge of the Rat King --";

    public static void printTitleScreen() {
        System.out.println(
            "-".repeat(screenWidth) + "\n" +
            "\n".repeat(10) +
            " ".repeat(calcPadding(gameTitle)[0]) + gameTitle + "\n" +
            " ".repeat(calcPadding(subTitle)[0]) + subTitle + "\n" +
            "\n".repeat(10) +
            "-".repeat(screenWidth) + "\n"
        );
    }

    public static void printGameState(Player player, Player opponent, int turnCount) {
        String opponentHp = "HP: "+opponent.getHealth()+" / "+opponent.getMaxHealth();
        String pl = "Player "+player.getId();
        String playerHp = "HP: "+player.getHealth()+" / "+player.getMaxHealth();
        String opponentPlay = "";
        String playerPlay = "";
        String playerHand = "";

        for(Card card : opponent.getPlay()) {
            CreatureCard c = (CreatureCard) card;
            opponentPlay = opponentPlay.concat(cardIndent + (opponent.getPlay().indexOf(c) + 1) + ". " + c.title + ", HP: " + c.health + "/" + c.maxHealth + " DMG: " + c.damage + "\n");
        }
        for(Card card : player.getPlay()) {
            CreatureCard c = (CreatureCard) card;
            playerPlay = playerPlay.concat(cardIndent + (player.getPlay().indexOf(c)+1)+". "+c.title+", HP: "+c.health+"/"+c.maxHealth + " DMG: " + c.damage + "\n");
        }
        for(Card card : player.getHand()) {
            String cardInfo = "";
            if(card instanceof CreatureCard) {
                CreatureCard c = (CreatureCard) card;
                cardInfo = cardIndent + (player.getHand().indexOf(card) + 1) + ". " + c.title + ", HP: " + c.health + "/" + c.maxHealth + " DMG: " + c.damage + "\n";
            } else if(card instanceof SpellCard) {
                SpellCard c = (SpellCard) card;
                cardInfo = cardIndent + (player.getHand().indexOf(card) + 1) + ". " + c.title+", HEAL: " + c.health + " DMG: " + c.damage + "\n";
            }
            playerHand = playerHand.concat(cardInfo);
        }

        System.out.println(
            "-".repeat(calcPadding(gameTitle)[0]) + gameTitle + "-".repeat(calcPadding(gameTitle)[1]) + "\n" +
            " ".repeat(calcPadding(subTitle)[0]) + subTitle + "\n" +
            " ".repeat(calcPadding("-".repeat(("Turn: " + turnCount).length()))[0]) + "-".repeat(("Turn: " + turnCount).length()) + "\n" +
            " ".repeat(calcPadding("Turn: " + turnCount)[0]) + "Turn: " + turnCount + "\n" +
            "\n" +
            " ".repeat(calcPadding("Opponent")[0]) + "Opponent" + "\n" +
            " ".repeat(calcPadding(opponentHp)[0]) + opponentHp + " ".repeat(calcPadding(opponentHp)[1]) + "\n" +
            "\n" +
            " ".repeat(calcPadding("- Opponent cards in play -")[0]) + "- Opponent cards in play -" + "\n" +
            " ".repeat(calcPadding("- Opponent cards in play -")[0]) + "-".repeat("- Opponent cards in play -".length()) + "\n" +
            opponentPlay + "\n" +
            " ".repeat(calcPadding("- Player " + player.getId() + " cards in play -")[0]) + "- Player " + player.getId() + " cards in play -" + "\n" +
            " ".repeat(calcPadding("- Player " + player.getId() + " cards in play -")[0]) + "-".repeat(("- Player " + player.getId() + " cards in play -").length()) + "\n" +
            playerPlay + "\n" +
            " ".repeat(calcPadding(pl)[0]) + pl + "\n" +
            " ".repeat(calcPadding(playerHp)[0]) + playerHp + " ".repeat(calcPadding(playerHp)[1]) + "\n" +
            "\n" +
            "-".repeat(calcPadding(" My Hand ")[0]) + " My Hand " + "-".repeat(calcPadding(" My Hand ")[1]) + "\n" +
            playerHand +
            "-".repeat(screenWidth) + "\n"
        );
    }

    public static void printGraveyard(Player player) {
        String graveyard = "";
        for(Card card : player.getGrave()) {
            if(card instanceof CreatureCard) {
                CreatureCard c = (CreatureCard) card;
                graveyard = graveyard.concat(cardIndent + (player.getGrave().indexOf(card)+1) + ". " + c.title + ", HP: " + c.health + "/" + c.maxHealth + " DMG: " + c.damage + "\n");
            }
            if(card instanceof SpellCard) {
                SpellCard c = (SpellCard) card;
                graveyard = graveyard.concat(cardIndent + (player.getGrave().indexOf(card)+1) + ". " + c.title + ", HEAL: " + c.health + " DMG: " + c.damage + "\n");
            }
        }

        System.out.println(
            "-".repeat(calcPadding(" Graveyard ")[0]) + " Graveyard " + "-".repeat(calcPadding(" Graveyard ")[1]) + "\n" +
            "\n" +
            graveyard + "\n" +
            "-".repeat(screenWidth)
        );
    }

    public static void printGameOver(Player winner, int turnCount) {
        String gameOverTitle = " Game Over ";
        String endMessage = "Player "+winner.getId()+" won in "+turnCount+" turns!";

        System.out.println(
            "-".repeat(calcPadding(gameOverTitle)[0]) + gameOverTitle + "-".repeat(calcPadding(gameOverTitle)[1]) + "\n" +
            "\n".repeat(10) +
            " ".repeat(calcPadding(endMessage)[0]) + endMessage + " ".repeat(calcPadding(endMessage)[1]) + "\n" +
            "\n".repeat(10) +
            "-".repeat(screenWidth)
        );
    }

    public static void printPlayerStart(Player player, int turnCount) {
        String title = " Turn "+turnCount+" ";
        String message = "Player "+player.getId()+" get ready! ";

        System.out.println(
                "-".repeat(calcPadding(title)[0]) + title + "-".repeat(calcPadding(title)[1]) + "\n" +
                        "\n".repeat(10) +
                        " ".repeat(calcPadding(message)[0]) + message + " ".repeat(calcPadding(message)[1]) + "\n" +
                        "\n".repeat(10) +
                        "-".repeat(screenWidth)
        );
    }

    public static void printSpacing(int rows) {
        System.out.print("\n".repeat(rows));
    }

    private static int[] calcPadding(String text) {
        return new int[]{(screenWidth/2-text.length()/2),screenWidth-(screenWidth/2-text.length()/2)-text.length()};
    }
}
