package TITAN;

public class Troll extends Card {
    public boolean activate(Board board, Controller ptrToCtrl){
        board.getActivePlayer().swapKingdom(board.getInactivePlayer());
        return true;
    }

    public String toString(){
        return "Troll";
    }

}
