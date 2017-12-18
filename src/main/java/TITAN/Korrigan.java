package TITAN;

/**
 * The Korrigan can draw 2 random cards within your opponent hand
 */
public class Korrigan extends Card {

    public boolean activate(Board board){
        board.getActivePlayer().steal(board.getInactivePlayer());
        return true;
    }

    public String toString(){
        return "Korrigan";
    }

}
