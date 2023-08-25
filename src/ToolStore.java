public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoş geldiniz!");
        return true;
    }
}
