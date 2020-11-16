package main;

public abstract class Card {
    private String title, description;

    public Card() {
        this.title = "Undefined";
        this.description = "Undefined";
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
