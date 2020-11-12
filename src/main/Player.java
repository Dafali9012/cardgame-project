package main;

import java.util.List;

public class Player {

    private String name;
    private int health;
    private int maxHealth;
    private int id;

    private List<Card> deck;
    private List<Card> hand;
    private List<Card> play;
    private List<Card> graveyard;


    public Player() {}

    public Player(String name, int id, int maxHealth){}

    public void modifyHealth(int health){
    }

    public boolean moveCard(Card card, List<Card> listA, List<Card> listB){
        return false;
    }
    public boolean setDeck(List<Card> deck){
        return false;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public void setId(int id) {
        this.id = id;
    }
}
