public class Game {
    Player[] players;
    Player player;
    Player opponent;
    int turnCounter = 1;

    public Game() {
        players = new Player[2];

        players[0] = new Player("p1", 1, 100);
        players[1] = new Player("p2", 2, 100);

        players[0].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card-templates")));
        players[1].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card-templates")));

        playerTurn();
    }

    private void playerTurn() {
        boolean creatureCardPlayed = false;
        boolean spellCardPlayed = false;

        updatePlayers();

        // play card (1/2)
        playCard();

        // play card (2/2)
        playCard();

        // attack with creature
        attack();

        // (option to end turn throughout) (option 0?)

        turnCounter++;
        endGameCheck();
    }

    private void attack() {}

    private void playCard() {}
    public boolean moveCard(int cardIndex, List<Card> from, List<Card> to){
        if (cardIndex<0) {
            return false;
        }
        else if (cardIndex>from.size()) {
            return false;
        }
        return to.add(from.remove(cardIndex));
    }

    private void updatePlayers() {
        for(Player player : players) {
            if(turnCounter % 2 == 0) {
                this.player = players[0];
                this.opponent = players[1];
            } else {
                this.player = players[1];
                this.opponent = players[0];
            }
        }
    }

    private void endGameCheck() {
        // if game is over -> print end screen
        // else playerTurn();
    }
}
