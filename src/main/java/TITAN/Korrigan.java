package TITAN;

public class Korrigan extends Card {

    public void activate(Board board){
        board.getActivePlayer().steal(board.getInactivePlayer());
    }
}
