import java.util.List;

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

    public boolean drawCard(Player player) {

        if(player.getHand().size() >= 4) moveCard(0, player.getDeck(), player.getHand());
        else for(int i = 0; i < (4-player.getHand().size()); i++)
            moveCard(0, player.getDeck(), player.getHand());

        return true;
    }

    private void attack() {}

    private void playCard() {}

    public void attackCard(CreatureCard attacker, CreatureCard victim){
        victim.modifyHealth(-attacker.damage);
    }

    public void attackOpponent(CreatureCard attacker, Player victim){
        victim.modifyHealth(-attacker.damage);
    }

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
        if(opponent.getHealth() < 1){
            System.out.println("You have won with " + player.getHealth()
                    + " remaining health");
        } else if(player.getHealth() < 1){
            System.out.println("Your opponent have won with " + opponent.getHealth()
                    + " remaining health");
        } else
            turnCounter++;
            updatePlayers();
    }
}
