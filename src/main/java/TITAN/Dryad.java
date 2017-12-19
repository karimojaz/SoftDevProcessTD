package TITAN;

import java.util.Scanner;

/***
 * the dryad can steal  a card in front of your opponent and add it in front of the current player  without activating its power.
 */

public class Dryad extends Card {

    private int index = -1;

    public boolean activate(Board board, Controller ptrToCtrl){
        if ( board.getInactivePlayer().getKingdom().getSize() > 0) {
            System.out.print("Pick a card from your opponent kingdom: ");
            Scanner sc = new Scanner(System.in);
            index = sc.nextInt();
            board.getActivePlayer().steal(board.getInactivePlayer(), index);
        }
        return true;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString(){
        return "Dryad";
    }
}
