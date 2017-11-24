package TITAN;
import java.util.Scanner;

public class Game {


    private Board board;


    //constructor
    public Game() {
        this.board = new Board();
    }

    //methods
    public void play(){
        while (!board.getDeck().isEmpty()){
            board.getActivePlayer().getHand().display();
            System.out.print("Pick a card in your hand to be played : ");

            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();

            board.getActivePlayer().playCard(index);
            board.newTurn();
        }

    }


}
