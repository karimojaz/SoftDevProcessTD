package TITAN;


/***
 * the gnome can draw 2 cards
 */
public class Gnome extends Card {

    public boolean activate(Board playground, Controller ptrToCtrl) {
        playground.getActivePlayer().draw(2);
        return true;
    }

    public String toString(){
        return "Gnome";
    }

}
