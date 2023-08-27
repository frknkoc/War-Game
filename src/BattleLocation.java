import java.util.Random;

public class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonsters;
    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonsters) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonsters = maxMonsters;
    }

    @Override
    public boolean onLocation() {
        int maxMonster = this.randomMonsterNumber();
        System.out.println("Şu anda " + this.getName() + "'dasın.");
        System.out.println("Dikkatli ol! Burada " + maxMonster + " " + this.getMonster().getName() + " yaşıyor.");
        System.out.println("Canavarla savaşamak için <S>, kaçmak için <K>'e basınız...");
        String selectBattle = input.nextLine();
        selectBattle = selectBattle.toUpperCase();
        if (selectBattle.equals("S")){
            System.out.println("Şu anda " + this.getName() + "'da " + maxMonster + " " + this.getMonster().getName() + " ile savaşıyorsun.");
        } else {
            System.out.println(maxMonster + " " + this.getMonster().getName() + "'den kaçtınız.");
        }
        return true;
    }

    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonsters()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonsters() {
        return maxMonsters;
    }

    public void setMaxMonsters(int maxMonsters) {
        this.maxMonsters = maxMonsters;
    }
}

