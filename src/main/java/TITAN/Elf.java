package TITAN;

public class Elf extends Card {

    private Card effect;

    public void activate(Board board){
        if (effect != null){
            effect.activate(board);
        }
    }

    public void setEffect(Card effect) {
        if (effect.getClass() != this.getClass()) {
            this.effect = effect;
        }
    }

    public Card getEffect() {
        return effect;
    }

    public String ToString(){
        return "Elf";
    }


}