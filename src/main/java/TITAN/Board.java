package TITAN;

import java.util.ArrayList;
import java.util.Collections;

public class Board
{
    private Deck cards;
    private Player activePlayer;
    private Player inactivePlayer;

    public Board() {
        this.cards = new Deck(42);
        this.activePlayer = new Player(this);
        this.inactivePlayer = new Player(this);
    }

    public Deck getDeck() {
        return cards;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getInactivePlayer() {
        return inactivePlayer;
    }

    public void newTurn() {
        Player p = activePlayer;
        activePlayer = inactivePlayer;
        inactivePlayer = p;
        activePlayer.draw(1);
    }

    public int score (Player player){
        int score = player.getKingdom().getSize();
        ArrayList<Integer> races = new ArrayList<Integer>();
        races.add(player.getKingdom().getGnomeNumber());
        races.add(player.getKingdom().getTrollNumber());
        races.add(player.getKingdom().getElfNumber());
        races.add(player.getKingdom().getDryadNumber());
        races.add(player.getKingdom().getGoblinNumber());
        races.add(player.getKingdom().getKorriganNumber());
        if (Collections.min(races) > 0){
            score += 3;
        }
        return score;
    }
}
