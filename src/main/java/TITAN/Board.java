package TITAN;

public class Board
{
    Deck cards;
    Player activePlayer;
    Player unactivePlayer;

    public Board() {
        this.cards = new Deck(42);
        this.activePlayer = new Player(this);
        this.unactivePlayer = new Player(this);
    }

    public Deck getDeck() {
        return cards;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getUnactivePlayer() {
        return unactivePlayer;
    }

    public void newTurn() {
        Player p = activePlayer;
        activePlayer = unactivePlayer;
        unactivePlayer = p;
        activePlayer.draw(1);
    }
}
