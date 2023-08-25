public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu anda Safe House'dasınız. Canınız yenilendi!");
        return true;
    }
}
