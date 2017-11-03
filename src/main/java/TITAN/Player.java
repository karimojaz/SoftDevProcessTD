package TITAN;

public class Player
{
    private Hand cards;
    private Board playGround;

    public Player(Board playGround)
    {
        this.playGround = playGround;
    }

    public Hand getHand() {
        return cards;
    }

    public Board getPlayGround() {
        return playGround;
    }
}
