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
        this.activePlayer.draw(1);
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
