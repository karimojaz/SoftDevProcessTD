package TITAN;

import java.util.ArrayList;
import java.util.Collections;

/***
 *
 * The class Board define the:
 *  Players kingdom
 *  Score
 *  the current player
 * the  player

 ***/
public class Board
{
    private Deck cards;
    private Player activePlayer, inactivePlayer, p1, p2;

    /*
    * Set the deck with 42 cards
    */

    public Board()
    {
        this.cards = new Deck(30);
        this.activePlayer = new Player(this);
        this.inactivePlayer = new Player(this);
        p1 = activePlayer;
        p2 = inactivePlayer;
        this.activePlayer.draw(1);
    }


    public Deck getDeck() {
        return cards;
    }
    public Player getP1() { return p1; }

    public Player getP2() { return p2; }

    /*
             * The current player
             */
    public Player getActivePlayer() {
        return activePlayer;
    }
    /*
     * The opponent
     */

    public Player getInactivePlayer() {
        return inactivePlayer;
    }

    /*
     * Altern the player on the game
     */

    public void newTurn() {
        Player p = activePlayer;
        activePlayer = inactivePlayer;
        inactivePlayer = p;
        activePlayer.draw(1);
    }
    /*
     *  Calculate the score for each player
     */
    public int score (Player player){
        int score = player.getKingdom().getSize();
        ArrayList<Integer> races = new ArrayList<Integer>();
        races.add(player.getKingdom().getRaceNumber(new Gnome()));
        races.add(player.getKingdom().getRaceNumber(new Troll()));
        races.add(player.getKingdom().getRaceNumber(new Elf()));
        races.add(player.getKingdom().getRaceNumber(new Dryad()));
        races.add(player.getKingdom().getRaceNumber(new Goblin()));
        races.add(player.getKingdom().getRaceNumber(new Korrigan()));
        if (Collections.min(races) > 0){
            score += 3;
        }
        return score;
    }
}
