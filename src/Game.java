import java.util.Scanner;

public class Game {
    public void start(){
        System.out.println("WarX Game'e hoş geldiniz!");
        System.out.println("Lütfen isminizi giriniz");
        Scanner input = new Scanner(System.in);
        String PlayerName = input.nextLine();
        PlayerName = PlayerName.substring(0, 1).toUpperCase() + PlayerName.substring(1).toLowerCase();
        Player player = new Player(PlayerName);
        System.out.println("Merhaba " + player.getPlayerName() + "! Oyunumuza hoş geldin :)");
        System.out.println("Oyuna başlamak için lütfen bir karakter seçiniz :");
        player.selectChar();
        Location location = null;
        while (true){
            System.out.println("\nLütfen oynamak istediğiniz lokasyonu seçiniz\n");
            System.out.println("<<Bölgeler>>\n1- Safe House\n2- Tool Store");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player); //new Player()
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (!location.onLocation()){
                System.out.println("Maalesef öldünüz :(");
                break;
            }


        }
    }
}
