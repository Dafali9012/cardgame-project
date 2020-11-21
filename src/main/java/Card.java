package main.java;

public abstract class Card {
    public String title, description;
    public String[] effect;

    public Card() {
        this.title = "undefined";
        this.description = "undefined";
        this.effect = new String[0];
    }

    public Card(String title, String description, String[] effect) {
        this.title = title;
        this.description = description;
        this.effect = effect;
    }
}
