public class SpellTemplate {
    private String title;
    private String description;
    private int healthModifier;
    private String[] methods;
    private int deckAmount;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDeckAmount() {
        return deckAmount;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public String[] getMethods() {
        return methods;
    }
}
