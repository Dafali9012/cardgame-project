public class SpellCard extends Card {
    int damage, heal;

    public SpellCard() {
        super();
        this.heal = 1;
        this.damage = 1;
    }

    public SpellCard(String title, String description, int heal, int damage) {
        super(title, description);
        this.heal = heal;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }
}
