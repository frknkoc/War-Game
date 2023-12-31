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
            System.out.println("<<Bölgeler>>\n1- Safe House\n2- Tool Store\n3- Mağaraya Git\n4- Nehire Git\n5- Ormana Git\n6- Çıkş Yap");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player); //new Player()
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Forest(player);
                    break;
                case 6:
                    location = null;
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null){
                System.out.println("Oyundan çıkış yaptınız...");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Maalesef öldünüz :(");
                break;
            }
        }
    }
}
