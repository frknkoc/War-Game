import java.util.Scanner;
public class Player {
    Scanner input = new Scanner(System.in);
    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String charName;

    public Player(String playerName){
        this.playerName = playerName;
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar(){
        GameCharacter[] Character = {new Samurai(), new Archer(), new Knight()};
        System.out.println("<<Karakterler>>");
        for (GameCharacter characters : Character
             ) {
            System.out.println("ID : " + characters.getId() +"\t Karakter : " +  characters.getPlayerName() + "\t Hasar : " + characters.getDamage() + "\t Sağlık : " + characters.getHealth() + "\t Para : " + characters.getMoney());
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
        this.setMoney(character.getMoney());
        this.setCharName(character.getPlayerName());
    }

    public void selectLocation(){
        Location location = null;
        System.out.println("Lütfen oynamak istediğiniz lokasyonu seçiniz");
        System.out.println("<<Bölgeler>>\n1- Safe House\n2- Tool Store");
        int selectLocation = input.nextInt();
        switch (selectLocation){
            case 1:
                location = new SafeHouse(this); //new Player()
                break;
            case 2:
                location = new ToolStore(this);
                break;
            default:
                location = new SafeHouse(this);
        }
        location.onLocation();
    }

}
