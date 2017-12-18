package TITAN;

/**
 * The Korrigan can draw 2 random cards within your opponent hand
 */
public class Korrigan extends Card {

    public void activate(Board board){
        board.getActivePlayer().steal(board.getInactivePlayer());
    }

    public String toString(){
        return "Korrigan";
    }

}
