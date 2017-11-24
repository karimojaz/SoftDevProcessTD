package TITAN;

public class Troll extends Card {
    public void activate(Board board){
        board.getActivePlayer().swapKingdom(board.getInactivePlayer());
    }

    public String toString(){
        return "Troll";
    }

}
