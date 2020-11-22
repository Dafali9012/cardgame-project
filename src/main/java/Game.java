import java.util.ArrayList;
import java.util.List;

public class Game {
    Player[] players;
    Player player;
    Player opponent;
    int turnCount = 1;
    boolean gameOver = false;

    public Game(boolean test) {

        players = new Player[2];

        players[0] = new Player("p1", 1, 100);
        players[1] = new Player("p2", 2, 100);

        players[0].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card_templates/standard")));
        players[1].setDeck(Cards.generateDeck(Cards.getCardTemplates("res/card_templates/standard")));

        if(!test) playerTurn();
    }

    public void playerTurn() {
        updatePlayers();

        playerChangeScreen();

        drawCard(player);

        Screen.printGameState(player, opponent, turnCount);

        playCard(1, 2, new ArrayList<>());

        attack();

        endGameCheck();
    }

    public void playerChangeScreen() {
        if(turnCount!=1) Screen.printSpacing(100);
        Screen.printPlayerStart(player,turnCount);
        Input.text("Enter nothing to continue: ", new String[]{""});
        Screen.printSpacing(100);
    }

    public void drawCard(Player player) {
        int handSize = player.getHand().size();
        if(handSize >= 4) moveCard(0, player.getDeck(), player.getHand());
        else for(int i = 0; i < (4-handSize); i++) moveCard(0, player.getDeck(), player.getHand());
    }

    public void attack() {
        int input = Input.number("Choose attacker (0 = skip): ", 0, player.getPlay().size());
        if(input==0) return;
        CreatureCard attacker = (CreatureCard) player.getPlay().get(input-1);
        if(opponent.getPlay().size()==0) modifyHealth(attacker.damage*-1, opponent);
        else {
            input = Input.number("Choose target: ", 1, opponent.getPlay().size());
            CreatureCard target = (CreatureCard) opponent.getPlay().get(input-1);
            modifyHealth(attacker.damage*-1, target);
        }
    }

    public void modifyHealth(int amount, Damagable target) {
        target.modifyHealth(amount);
    }

    public void playCard(int cardNum, int maxCards, List<String> typesPlayed) {
        int input = Input.number("Play card ("+cardNum+"/"+maxCards+") (0 = skip): ", 0, player.getHand().size());
        if(input==0) return;
        Card selectedCard = player.getHand().get(input-1);

        while(selectedCard instanceof CreatureCard && typesPlayed.stream().anyMatch("creature"::equals) ||
                selectedCard instanceof SpellCard && typesPlayed.stream().anyMatch("spell"::equals)) {

            System.out.println("You may only play one card of each type");
            input = Input.number("Play card ("+cardNum+"/"+maxCards+", skip=0): ", 0, player.getHand().size());
            if(input==0) return;
            selectedCard = player.getHand().get(input-1);
        }

        if(selectedCard instanceof CreatureCard) {
            resolveCardEffect(selectedCard);
            moveCard(input-1, player.getHand(), player.getPlay());
            typesPlayed.add("creature");
        } else if(selectedCard instanceof SpellCard) {
            resolveCardEffect(selectedCard);
            moveCard(input-1, player.getHand(), player.getGrave());
            typesPlayed.add("spell");
        }

        Screen.printSpacing(1);
        Screen.printGameState(player, opponent, turnCount);

        if(cardNum!=maxCards)playCard(cardNum+1, maxCards, typesPlayed);
    }

    public void resolveCardEffect(Card card) {
        if(card.effect.length==0) return;
    }

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

    public void moveCard(int cardIndex, List<Card> from, List<Card> to){
        if (cardIndex >= 0 && cardIndex < from.size()) to.add(from.remove(cardIndex));
    }

    public void endGameCheck() {
        if(gameOver) Screen.printGameOver(player, turnCount);
        else {
            turnCount++;
            playerTurn();
        }
    }

    public boolean checkHp(Damagable target){
        return target.getClass().getSimpleName().equals("Player");
    }
}
