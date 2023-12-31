public abstract class GameCharacter {
    private int id;
    private String playerName;
    private int damage;
    private int health;
    private int money;

    public GameCharacter(int id, String playerName, int damage, int health, int money) {
        this.id = id;
        this.playerName = playerName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
