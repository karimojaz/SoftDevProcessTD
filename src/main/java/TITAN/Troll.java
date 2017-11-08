package TITAN;

public class Troll extends Card {
    public void activate(Board board){
        board.getActivePlayer().swapKingdom(board.getUnactivePlayer());
    }
}
