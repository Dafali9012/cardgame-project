public class SpellCard extends Card {
    public int health, damage;

    public SpellCard() {
        super();
        this.health = 1;
        this.damage = 1;
    }

    public SpellCard(String title, String description, String[] effect, int health, int damage) {
        super(title, description, effect);
        this.health = health;
        this.damage = damage;
    }
}
