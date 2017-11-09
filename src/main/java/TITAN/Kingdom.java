package TITAN;

import java.util.ArrayList;

public class Kingdom
{
    private ArrayList<Card> cardsInKingdom;
    private Player owner;

    public Kingdom(Player owner)
    {
        this.owner = owner;
        cardsInKingdom = new ArrayList<Card>();
    }

    public Player getOwner() { return owner; }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public ArrayList<Card> getCardsInKingdom() {
        return cardsInKingdom;
    }

    public Card popAt(int index){
        Card popped = cardsInKingdom.get(index);
        cardsInKingdom.remove(index);
        return popped;
    }
    
    public int getGnomeNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Gnome){
                count ++;
            }
        }
        return count;
    }

    public int getTrollNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Troll){
                count ++;
            }
        }
        return count;
    }

    public int getGoblinNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Goblin){
                count ++;
            }
        }
        return count;
    }

    public int getDryadNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Dryad){
                count ++;
            }
        }
        return count;
    }

    public int getKorriganNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Korrigan){
                count ++;
            }
        }
        return count;
    }

    public int getElfNumber(){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card instanceof Elf){
                count ++;
            }
        }
        return count;
    }

    public int getSize(){
        return cardsInKingdom.size();
    }

    public void add(Card c){
        cardsInKingdom.add(c);
    }
}
