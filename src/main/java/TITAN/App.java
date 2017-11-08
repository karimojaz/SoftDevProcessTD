package TITAN;


public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Board b = new Board();

        System.out.println("avant");
        System.out.println(b.getActivePlayer().getHand().getSize());
        System.out.println(b.getActivePlayer().getKingdom().getGnomeNumber());
        System.out.println(b.getDeck().getSize());
        System.out.println("après");
        b.getActivePlayer().playCard(3);
        b.getActivePlayer().playCard(3);
        b.getActivePlayer().playCard(0);
        System.out.println(b.getActivePlayer().getHand().getSize());
        System.out.println(b.getDeck().getSize());
        System.out.println("actif");
        System.out.println(b.getActivePlayer().getHand().getSize());
        System.out.println(b.getActivePlayer().getKingdom().getGnomeNumber());
        System.out.println(b.getActivePlayer().getKingdom().getGoblinNumber());
        System.out.println("inactif");
        System.out.println(b.getUnactivePlayer().getHand().getSize());
        System.out.println(b.getUnactivePlayer().getKingdom().getGnomeNumber());
        System.out.println(b.getUnactivePlayer().getKingdom().getTrollNumber());

    }
}