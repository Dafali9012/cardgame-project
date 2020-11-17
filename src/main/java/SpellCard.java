public class SpellCard extends Card {
    int healthModifier;
    String[] methods;

    public SpellCard() {
        super();
        this.healthModifier = 1;
        this.methods = new String[]{"player-play-modifyhealth-all"};
    }

    public SpellCard(String title, String description, int healthModifier, String[] methods) {
        super(title, description);
        this.healthModifier = healthModifier;
        this.methods = methods;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public String[] getMethods() {
        return methods;
    }
}
