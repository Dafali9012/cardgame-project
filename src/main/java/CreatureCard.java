public class CreatureCard extends Card implements Damagable {
    public int maxHealth, health, defaultDamage, damage;

    public CreatureCard() {
        super();
        this.maxHealth = 1;
        this.health = 1;
        this.defaultDamage = 1;
        this.damage = 1;
    }

    public CreatureCard(String title, String description, String[] effect, int health, int damage) {
        super(title, description, effect);
        this.maxHealth = health;
        this.health = health;
        this.defaultDamage = damage;
        this.damage = damage;
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
    public int getHealth() {
        return health;
    }
}
