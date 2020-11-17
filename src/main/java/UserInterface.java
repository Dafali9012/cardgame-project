import java.util.List;

public class UserInterface {
    private void askForUsername(){
        System.out.println("Write username:");
    }
    private void displayTurnOptions(){
    }

    public void displayPlayersNameAndHp(){
    }

    public void displayCreatureCard(){
    }

    public void displayHand(){
    }

    public String dispenseHand(List<Card> cards ){
        return null;
    }

    public String dispensePlayerNameAndHp(Player player){
        return null;
    }

    public String dispenseCreatureCard(Card card){
        String dots = "..." ;
        String cardFormat ="";

        switch (card.getClass().getSimpleName()){

            case "CreatureCard":
                dots = dots + getDots(card.getDescription().length());
                cardFormat =  String.format("%s \n. %s \n. %s \n. HP :%s \n. ATk: %s\n %s",
                        dots,
                        card.getTitle(),
                        card.getDescription(),
                        ((CreatureCard) card).getHealth(),
                        ((CreatureCard) card).getDamage(),
                        dots

                );
            break;

            case "SpellCard":
               dots = dots + getDots(card.getDescription().length());
                cardFormat =  String.format("%s \n. %s \n. %s \n. HP: %s \n. ATK: %s \n %s",
                        dots,
                        card.getTitle(),
                        card.getDescription(),
                        ((SpellCard) card).getHealthModifier(),
                        dots

                );
            break;
        }

        return cardFormat;
    }

    private String getDots(int size){
        StringBuilder dots  = new StringBuilder();

        for (int i = 0; i < size; i++){
            dots.append(".");
        }

        return dots.toString();
    }


}
