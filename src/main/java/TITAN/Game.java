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
            System.out.println("Opponent "+board.getInactivePlayer().getKingdom());
            System.out.println("Your "+board.getActivePlayer().getKingdom());
            System.out.println(board.getActivePlayer().getHand());
            System.out.print("Pick a card in your hand to be played : ");

            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();

            board.getActivePlayer().playCard(index);
            board.newTurn();
        }
        while (!board.getActivePlayer().getHand().isEmpty() ){
            System.out.println("Opponent "+board.getInactivePlayer().getKingdom());
            System.out.println("Your "+board.getActivePlayer().getKingdom());
            System.out.println(board.getActivePlayer().getHand());
            System.out.print("Pick a card in your hand to be played : ");

            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();

            board.getActivePlayer().playCard(index);

            if ( board.getInactivePlayer().getHand().isEmpty())
            {
                break;
            }
            else{
                board.newTurn();
            }
        }
        //score
    }


}
