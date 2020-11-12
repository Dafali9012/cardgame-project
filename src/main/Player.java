package main;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int health;
    private int maxHealth;
    private int id;

    private List<Card> deck = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();
    private List<Card> play = new ArrayList<>();
    private List<Card> graveyard = new ArrayList<>();


    public Player() {}

    public Player(String name, int id, int maxHealth){
        this.name = name;
        this.id = id;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void modifyHealth(int harm){
        int recent = (this.health + harm);
        if(recent > maxHealth){
            this.health = this.maxHealth;
        }
        else if(recent < 0){
            this.health = 0;
        }
        else this.health = recent;
    }

    public boolean moveCard(Card card, List<Card> listA, List<Card> listB){
        return false;
    }

    public boolean setDeck(List<Card> deck){
        return false;
    }

    public List<Card> getDeck(){
        return deck;
    }
    public List<Card> getCardHand(){
        return hand;
    }
    public List<Card> getCardPlay(){
        return play;
    }
    public List<Card> getGraveyard(){
        return graveyard;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

}
