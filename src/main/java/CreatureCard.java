public class CreatureCard extends Card {
    private final int maxHealth;
    private int health;
    private final int defaultDamage;
    private int damage;

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

    public void modifyHealth(int amount) {
        int result = this.health + amount;
        if(result < 0) this.health = 0;
        else this.health = Math.min(result, this.maxHealth);
    }

    public void modifyDamage(int amount) {
        int result = this.damage + amount;
        this.damage = Math.max(result, 0);
    }

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
