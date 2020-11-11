package main;

public abstract class Card {
    private String title, description;

    public Card() {}

    public Card(String title, String description) {}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
