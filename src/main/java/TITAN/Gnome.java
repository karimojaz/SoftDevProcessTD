package TITAN;


/***
 * the gnome can draw 2 cards
 */
public class Gnome extends Card {

    public void activate(Board playground) {
        playground.getActivePlayer().draw(2);
    }

    public String toString(){
        return "Gnome";
    }

}
