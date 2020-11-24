import java.util.ArrayList;
import java.util.List;

public class Game {
    Player[] players;
    Player player;
    Player opponent;
    int turnCount = 1;
    boolean gameOver = false;

    public Game() {
        initialSetup();
        playerTurn();
    }

    public Game(boolean test) {
        initialSetup();
        if(test) updatePlayers();
        else playerTurn();
    }

    private void initialSetup() {
        players = new Player[2];

        players[0] = new Player("p1", 1, 100);
        players[1] = new Player("p2", 2, 100);

        players[0].setDeck(Cards.generateDeck(Cards.getCardTemplates("/card_templates/standard")));
        players[1].setDeck(Cards.generateDeck(Cards.getCardTemplates("/card_templates/standard")));

        drawCard(players[0]);
        drawCard(players[1]);
    }

    public void playerTurn() {
        updatePlayers();

        playerChangeScreen();

        drawCard(player);

        Screen.printGameState(player, opponent, turnCount);

        playCard(1, 2, new ArrayList<>());
        if(gameOverCheck()) return;

        attack();
        if(gameOverCheck()) return;

        turnCount++;
        playerTurn();
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
        checkHp(target);
    }

    public void playCard(int cardNum, int maxCards, List<String> typesPlayed) {
        boolean success = false;

        while(!success) {
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
                success = resolveCardEffect(selectedCard);
                if(success) {
                    moveCard(input-1, player.getHand(), player.getPlay());
                    typesPlayed.add("creature");
                }
            } else if(selectedCard instanceof SpellCard) {
                success = resolveCardEffect(selectedCard);
                if(success) typesPlayed.add("spell");
            }
        }

        Screen.printSpacing(1);
        Screen.printGameState(player, opponent, turnCount);
        if(gameOver) return;
        if(cardNum!=maxCards)playCard(cardNum+1, maxCards, typesPlayed);
    }

    public boolean resolveCardEffect(Card card) {
        if(card.effect.length==0) return true;

        for(String instruction : card.effect) {
            String[] iSplit = instruction.split("-");

            Player target = null;

            if(iSplit[0].equals("destroy")) {
                moveCard(player.getHand().indexOf(card), player.getHand(), player.getGrave());
                return true;
            }

            if(iSplit[0].equals("player")) target = this.player;
            else if(iSplit[0].equals("opponent")) target = this.opponent;

            if(iSplit[1].equals("healone")) {
                if(target.getPlay().size()==0) {
                    System.out.println("No targets available");
                    return false;
                }
                int input = Input.number("choose target: ", 1, target.getPlay().size());
                modifyHealth(((SpellCard) card).health, (CreatureCard) target.getPlay().get(input-1));
            }
            if(iSplit[1].equals("healall")) {
                for(Card cardInPlay : target.getPlay()) {
                    modifyHealth(((SpellCard) card).health, (CreatureCard) cardInPlay);
                }
                modifyHealth(((SpellCard) card).health, target);
            }
            if(iSplit[1].equals("healself")) {
                modifyHealth(((SpellCard) card).health, target);
            }

            if(iSplit[1].equals("dmgone")) {
                if(target.getPlay().size()==0) modifyHealth(((SpellCard) card).damage*-1, target);
                else {
                    int input = Input.number("choose target: ", 1, target.getPlay().size());
                    modifyHealth(((SpellCard) card).damage*-1, (CreatureCard) target.getPlay().get(input-1));
                }
            }
            if(iSplit[1].equals("dmgall")) {
                for(Card cardInPlay : target.getPlay()) {
                    modifyHealth(((SpellCard) card).damage*-1, (CreatureCard) cardInPlay);
                }
                modifyHealth(((SpellCard) card).damage*-1, target);
            }
            if(iSplit[1].equals("dmgself")) {
                modifyHealth(((SpellCard) card).damage*-1, target);
            }

            if(iSplit[1].equals("ress")) {
                if(!target.getGrave().stream().anyMatch(CreatureCard.class::isInstance)) {
                    System.out.println("No cards applicable for resurrection");
                    return false;
                }
                Screen.printSpacing(1);
                Screen.printGraveyard(target);
                Screen.printSpacing(1);

                int input = Input.number("Choose target (0 = cancel): ", 0, target.getGrave().size());
                if(input==0) {
                    Screen.printSpacing(1);
                    Screen.printGameState(player, opponent, turnCount);
                    return false;
                }
                Card selectedCard = target.getGrave().get(input-1);

                while(selectedCard instanceof SpellCard) {
                    System.out.println("Only creature cards are applicable for resurrection");
                    input = Input.number("Choose target (0 = cancel): ", 0, target.getGrave().size());
                    if(input==0) {
                        Screen.printSpacing(1);
                        Screen.printGameState(player, opponent, turnCount);
                        return false;
                    }
                    selectedCard = target.getGrave().get(input-1);
                }
                moveCard(input-1, target.getGrave(), target.getHand());
            }
        }
        return true;
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

    public boolean gameOverCheck() {
        if(gameOver) {
            Screen.printGameOver(player, turnCount);
            return true;
        }
        return false;
    }

    public void checkHp(Damagable target){
        if (target instanceof Player){
            if (target.getHealth()<1){
                gameOver = true;
            }
        }
        if(target instanceof CreatureCard) {
            if (target.getHealth()<1){
                moveCard(opponent.getPlay().indexOf(target), opponent.getPlay(),opponent.getGrave());
                modifyHealth(target.getMaxHealth()*-1,opponent);
            }
        }
    }
}
