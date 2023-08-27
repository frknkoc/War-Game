public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoş geldiniz!");
        System.out.println("Yapmak istediğiniz işlemi seçiniz :\n1- Silahlar\n2- Zırhlar\n3- Çıkış Yap");
        int selectTool = input.nextInt();
        while (selectTool < 1 || selectTool > 3){
            System.out.println("Geçersiz değer!!!");
            selectTool = input.nextInt();
        }
        switch (selectTool){
            case 1:
                System.out.println("Silah reyonuna geldiniz!");
                printWeapon();
                buyWeapon();
                break;
            case 2:
                System.out.println("Zırh reyonuna geldiniz");
                printArmor();
                buyArmor();
                break;
            case 3:
                return true;
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("<< Silahlar >>");
        System.out.println("Bir silah seçiniz...");
        for (Weapon weap : Weapon.weapons()
             ) {
            System.out.println(weap.getWeaponName() + "\t << Money : " + weap.getPrice() + "£ >> " + "\t << Damage : " + weap.getDamage() + " >> ");
        }

    }

    public void buyWeapon(){
        this.getPlayer().printPlayerInfo();
        int selectWeapon = input.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length){
            System.out.println("Geçersiz değer!!!");
            selectWeapon = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);

        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
            } else {
                System.out.println(selectedWeapon.getWeaponName() + "'i satın aldınız");
                int newMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Kalan para : " + this.getPlayer().getMoney() + "£");
                System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Şu anki silahınız : " + this.getPlayer().getInventory().getWeapon().getWeaponName());
            }
        }
        this.getPlayer().printPlayerInfo();
    }
    public void printArmor(){
        System.out.println("<<Armorlar>>");
        System.out.println("Bir armor seçiniz...");
        for (Armor armor : Armor.armors()
        ) {
            System.out.println(armor.getName() + "\t << Money : " + armor.getPrice() + "£ >> " + "\t << Block : " + armor.getBlock() + " >> ");
        }
    }

    public void buyArmor(){
        this.getPlayer().printPlayerInfo();
        int selectArmor = input.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length){
            System.out.println("Geçersiz değer!!!");
            selectArmor = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmor);

        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
            } else {
                System.out.println(selectedArmor.getName() + "'ı satın aldınız");
                int newMoney = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Kalan para : " + this.getPlayer().getMoney() + "£");
                System.out.println("Önceki engelleme : " + this.getPlayer().getInventory().getArmor().getBlock());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Şu anki engelleme : " + this.getPlayer().getInventory().getArmor().getBlock());
            }
        }
        this.getPlayer().printPlayerInfo();
    }
}
