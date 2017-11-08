package TITAN;

public class Gnome extends Card {

    public void activate(Board playground) {
        playground.getActivePlayer().draw(2);
    }

}
