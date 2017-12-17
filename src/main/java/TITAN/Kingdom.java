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


    public int getRaceNumber(Card race){
        int count = 0;
        for (Card card : cardsInKingdom) {
            if (card.getClass() == race.getClass()){
                count ++;
            }
        }
        return count;
    }

    public String toString(){
        String string = "Kingdom : ";
        for (int i=0; i<this.getSize(); i++){
            string += cardsInKingdom.get(i) + ", " + i + " ; ";
        }
        return string;
    }

    public int getSize(){
        return cardsInKingdom.size();
    }

    public void add(Card c){
        cardsInKingdom.add(c);
    }
}
