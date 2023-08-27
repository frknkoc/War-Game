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
        String selectBattle = input.nextLine().toUpperCase();
        if (selectBattle.equals("S")){
            System.out.println("Şu anda " + this.getName() + "'da " + maxMonster + " " + this.getMonster().getName() + " ile savaşıyorsun.");
            if (combat(maxMonster)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz!!!");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("Maalesef öldünüz :(");
            return false;
        }

        return true;
    }

    public boolean combat(int maxMonster){
        for (int i = 1; i <= maxMonster; i++){
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            this.getPlayer().printPlayerInfo();
            monsterInfo(i);
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("Vurmak için <V> \t Kaçmaki için <K>");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz...");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0){
                        System.out.println("\nCanavar size vurdu...\n");
                        int totalDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (totalDamage < 0){
                            System.out.println("Canavarı öldürdünüz! Tebrikler :)");
                            totalDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - totalDamage);
                        afterHit();
                    }
                } else {
                    System.out.println("Kaçtınız...");
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getMonster().getAward() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "'in canı : " + this.getMonster().getHealth());
    }

    public void monsterInfo(int i){
        System.out.println("\n" + i + ". " + this.getMonster().getName() + " \t" +
                " Kalan can : " + this.getMonster().getHealth() + " \t" +
                " Hasar : " + this.getMonster().getDamage() + " \t" +
                " Ödül : " + this.getMonster().getAward());
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

