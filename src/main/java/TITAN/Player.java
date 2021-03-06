package TITAN;

import java.util.Random;

/**
 * Define each player
 *  the player has a set of cards, a kingdom and a board
 */

public class Player
{
    private Hand cards;
    private Board playGround;
    private Kingdom cardsPlayed;
    private int score;

    public Player(Board playGround) {
        this.playGround = playGround;
        this.cardsPlayed = new Kingdom(this);
        this.cards = new Hand(this);
        score = 0;
    }

    public Hand getHand() {
        return cards;
    }

    public Board getBoard() {
        return playGround;
    }

    public Kingdom getKingdom() {
        return cardsPlayed;
    }

    private void setKingdom(Kingdom cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    private void setHand(Hand cards) {
        this.cards = cards;
    }

    /*
     * the player choose a card in his hand and play it, the hand is reduced
     */
    public void playCard(int index, Controller ptrToController){
        Card played = cards.popAt(index);
        cardsPlayed.add(played);
        played.activate(playGround, ptrToController);
    }

    /*
     * the player pick a card in the deck
     */
    public void draw(int number){
        for (int i = 0; i < number; i++) {
            if (playGround.getDeck().getSize()>0) {
                cards.add(playGround.getDeck().pop());
            }
        }
    }

    /*
     * the current player steals randomly a card in his  opponent hand
     */
    public void steal(Player opponent){
        Random rand = new Random();
        if (opponent.getHand().getSize()>0) {
            int randomInt = rand.nextInt(opponent.getHand().getSize());
            cards.add(opponent.getHand().popAt(randomInt));
        }
        if (opponent.getHand().getSize()>0) {
            int randomInt = rand.nextInt(opponent.getHand().getSize());
            cards.add(opponent.getHand().popAt(randomInt));
        }
    }

    /*
     * the current player  steals a chosen card in his opponent hand
     */

    public void steal(Player opponent, int index){
        if (index != -1) {
            cardsPlayed.add(opponent.getKingdom().popAt(index));
        }
    }

    /*
     * the current player and the opponnent  kingdoms are swapped
     */
    public void swapKingdom(Player opponent){
        Kingdom k = this.cardsPlayed;
        this.setKingdom(opponent.getKingdom());
        opponent.setKingdom(k);
        this.cardsPlayed.setOwner(this);
        opponent.getKingdom().setOwner(opponent);
    }

    /*
     * the current player and the opponnent hand  are swapped
     */

    public void swapHand(Player opponent){
        Hand h = this.cards;
        this.setHand(opponent.getHand());
        opponent.setHand(h);
        this.cards.setOwner(this);
        opponent.getHand().setOwner(opponent);
    }

    public int getScore() {return score;}

    public void calculateScore()
    {
        score = getKingdom().getSize();
        Card c;
        int dry = 0;
        int elf = 0;
        int gno = 0;
        int gob = 0;
        int korr  = 0;
        int troll = 0;

        for(int i = 0; i<getKingdom().getSize(); i++)
        {
            c = getKingdom().getCardsInKingdom().get(i);

            if(c instanceof Dryad)
                dry++;
            else if(c instanceof Elf)
                elf++;
            else if(c instanceof Gnome)
                gno++;
            else if(c instanceof Goblin)
                gob++;
            else if(c instanceof Korrigan)
                korr++;
            else if(c instanceof Troll)
                troll++;
        }

        int races[] = {dry, elf, gno, gob, korr, troll};
        for(int i = 0; i<5; i++)
            if(races[i] >= 3) score +=3;
    }
}
