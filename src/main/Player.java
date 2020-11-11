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

    public Player(String name, int id, int health){
        this.name = name;
        this.id = id;
        this.health = health;
    }

    public int modifyHealth(int health){
        return 0;
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

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setId(int id) {
        this.id = id;
    }
}
