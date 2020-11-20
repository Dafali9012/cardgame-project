import java.util.List;

public class Game {
    Player[] players;
    Player player;
    Player opponent;
    int turnCount = 1;

    public Game() {
        players = new Player[2];

        players[0] = new Player("p1", 1, 100);
        players[1] = new Player("p2", 2, 100);

        players[0].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card_templates/only-creatures")));
        players[1].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card_templates/only-creatures")));

        for(int i = 0; i < 4; i++) {
            moveCard(0, players[0].getDeck(), players[0].getPlay());
            moveCard(0, players[1].getDeck(), players[1].getPlay());
        }

        playerTurn();
    }

    public void playerTurn() {
        boolean creatureCardPlayed = false;
        boolean spellCardPlayed = false;

        updatePlayers();

        drawCard(player);

        Screen.printGameState(player, opponent, turnCount);

        // play card (1/2)
        playCard();

        // play card (2/2)
        playCard();

        // attack with creature
        attack();

        // (option to end turn throughout) (option 0?)

        turnCount++;
        endGameCheck();
    }

    public void drawCard(Player player) {
        int handSize = player.getHand().size();
        if(handSize >= 4) moveCard(0, player.getDeck(), player.getHand());
        else for(int i = 0; i < (4-handSize); i++) moveCard(0, player.getDeck(), player.getHand());
    }

    public void attack() {}

    public void playCard() {}

    public void updatePlayers() {
        for(Player player : players) {
            if(turnCount % 2 == 0) {
                this.player = players[1];
                this.opponent = players[0];
            } else {
                this.player = players[0];
                this.opponent = players[1];
            }
        }
    }

    public boolean moveCard(int cardIndex, List<Card> from, List<Card> to){
        if (cardIndex < 0) return false;
        else if (cardIndex > from.size()) return false;
        to.add(from.remove(cardIndex));
        return true;
    }

    public void endGameCheck() {
        // if game is over -> print end screen
        // else playerTurn();
    }
}
