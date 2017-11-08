package TITAN;

public class Goblin extends Card {

    public void activate(Board board){
        board.getActivePlayer().swapHand(board.getUnactivePlayer());
    }
}
