import java.util.Scanner;
public class Player {
    Scanner input = new Scanner(System.in);
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String playerName;
    private String charName;
    private Inventory inventory;

    public Player(String playerName){
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void printPlayerInfo(){
        System.out.println("\n" + this.getPlayerName() + " \t" +
                " Kalan can : " + this.getHealth() + " Damage : " +
                this.getDamage() + " Elindeki silah : " +
                this.getInventory().getWeapon().getWeaponName() + " \t" +
                 " Zırh : " +
                this.getInventory().getArmor().getName() + " \t" +
                " Blok : " +
                this.getInventory().getArmor().getBlock() +"\n");
    }
    public void selectChar(){
        GameCharacter[] Character = {new Samurai(), new Archer(), new Knight()};
        System.out.println("\n<<Karakterler>>\n");
        for (GameCharacter characters : Character
             ) {
            System.out.println( + characters.getId() +"- \t Karakter : " +  characters.getPlayerName() + "\t Hasar : " + characters.getDamage() + "\t Sağlık : " + characters.getHealth() + "\t Para : " + characters.getMoney());
        }
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println(getCharName() + " karakterini seçtiniz." + "\t Hasar : " + getDamage() + "\t Sağlık : " + getHealth() + "\t Para : " + getMoney());
    }

    public void initPlayer(GameCharacter character){
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setOriginalHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getPlayerName());
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
