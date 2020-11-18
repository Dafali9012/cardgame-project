public abstract class Card {
    public String title, description;

    public Card() {
        this.title = "undefined";
        this.description = "undefined";
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
