package main;

public class SpellCard extends Card {
    int damage, heal;

    public SpellCard() {
        super();
        this.damage = 1;
        this.heal = 1;
    }

    public SpellCard(String title, String description, int damage, int heal) {
        super(title, description);
        this.damage = damage;
        this.heal = heal;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }
}
