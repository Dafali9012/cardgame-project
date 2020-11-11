package main;

public class CreatureCard extends Card {
    private int maxHealth, health, defaultDamage, damage;

    public CreatureCard() {
        super();
        this.maxHealth = 1;
        this.health = 1;
        this.defaultDamage = 1;
        this.damage = 1;
    }

    public CreatureCard(String title, String description, int maxHealth, int defaultDamage) {
        super(title, description);
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.defaultDamage = defaultDamage;
        this.damage = defaultDamage;
    }

    public void modifyHealth(int amount) {}

    public void modifyDamage(int amount) {}

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getDefaultDamage() {
        return defaultDamage;
    }

    public int getDamage() {
        return damage;
    }
}
