package TITAN;

public class Elf extends Card {

    private Card effect;

    public void activate(Board board){
        effect.activate(board);
    }

    public void setEffect(Card effect) {
        this.effect = effect;
    }

    public Card getEffect() {
        return effect ;
    }
}