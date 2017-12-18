package TITAN;

/***
 *The goblin can  switch the hand of the current player  with his  opponent
 */
public class Goblin extends Card {

    public void activate(Board board){
        board.getActivePlayer().swapHand(board.getInactivePlayer());
    }

    public String toString(){
        return "Goblin";
    }
}
