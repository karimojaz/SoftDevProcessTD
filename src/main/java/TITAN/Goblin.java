package TITAN;

/***
 *The goblin can  switch the hand of the current player  with his  opponent
 */
public class Goblin extends Card {

    public boolean activate(Board board, Controller ptrToCtrl)
    {
        board.getActivePlayer().swapHand(board.getInactivePlayer());
        return true;
    }

    public String toString(){
        return "Goblin";
    }
}
