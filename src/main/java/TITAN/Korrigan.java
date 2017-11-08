package TITAN;

public class Korrigan extends Card {

    public void activate(Board board){
        board.getActivePlayer().draw(board.getUnactivePlayer());
    }
}
