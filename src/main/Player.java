package main;

import java.util.List;

public class Player {
    private String name;
    private int health;
    private int id;

    private List<Card> deck;
    private List<Card> hand;
    private List<Card> play;
    private List<Card> graveyard;


    public Player() {}

    public Player(String name, int id, int health){}

    public int modifyHealth(int health){
        return 0;
    }
    public boolean moveCard(Card card, List<Card> listA, List<Card> listB){
        return false;
    }
    public boolean setDeck(List<Card> deck){
        return false;
    }

}
