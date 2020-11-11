package main;

public class CreatureCard extends Card {
    private int maxHealth, health, defaultDamage, damage;

    public CreatureCard() {}

    public CreatureCard(String title, String description, int maxHealth, int defaultDamage) {}

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
