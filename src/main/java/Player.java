package main.java;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int health;
    private final int maxHealth;
    private final int id;

    private List<Card> deck = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();
    private List<Card> play = new ArrayList<>();
    private List<Card> grave = new ArrayList<>();


    public Player() {
        this.name = "NoName";
        this.id = 0;
        this.health = 0;
        this.maxHealth = 0;
    }

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

    public List<Card> setDeck(List<Card> deck){
        return this.deck = deck;
    }

    public List<Card> setHand(List<Card> hand) {
        return this.hand = hand;
    }

    public List<Card> setPlay(List<Card> play) {
        return this.play = play;
    }

    public List<Card> setGrave(List<Card> grave) {
        return this.grave = grave;
    }

    public List<Card> getDeck(){
        return deck;
    }

    public List<Card> getHand(){
        return hand;
    }

    public List<Card> getPlay(){
        return play;
    }

    public List<Card> getGrave(){
        return grave;
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
