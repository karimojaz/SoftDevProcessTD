package TITAN;

import java.util.Scanner;

public class Dryad extends Card {

    private int index;

    public void activate(Board board){
        System.out.print("Pick a card from your opponent kingdom: ");
        Scanner sc = new Scanner(System.in);
        index = sc.nextInt();
        board.getActivePlayer().steal(board.getInactivePlayer(), index);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString(){
        return "Dryad";
    }
}
