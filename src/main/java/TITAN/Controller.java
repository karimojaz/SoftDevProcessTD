package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private Board board;
    private ArrayList<ImageView> P1HAND, P2HAND, P1K, P2K;
    private Image dry, elf, gno, gob, korr, troll, bottom;
    @FXML private ImageView p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10, p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10, k1_c1, k1_c2, k1_c3, k1_c4, k1_c5, k1_c6, k1_c7, k2_c1, k2_c2, k2_c3, k2_c4, k2_c5, k2_c6, k2_c7;
    @FXML private Label deckCounter;
    private Card selectedCard;

    public Controller()
    {
        board = new Board();
        dry = new Image(new File("resources/image/Dryad.png").toURI().toString());
        elf = new Image(new File("resources/image/Elf.png").toURI().toString());
        gno = new Image(new File("resources/image/Gnome.png").toURI().toString());
        gob = new Image(new File("resources/image/Goblin.png").toURI().toString());
        korr = new Image(new File("resources/image/Korrigan.png").toURI().toString());
        troll = new Image(new File("resources/image/Troll.png").toURI().toString());
        bottom = new Image(new File("resources/image/EmptySlot.png").toURI().toString());
        selectedCard = null;
    }

    @FXML public void initialize(URL location, ResourceBundle resources)
    {
        P1HAND = new ArrayList<>(Arrays.asList(p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10));
        P2HAND = new ArrayList<>(Arrays.asList(p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10));
        P1K = new ArrayList<>(Arrays.asList(k1_c1, k1_c2, k1_c3, k1_c4, k1_c5, k1_c6, k1_c7));
        P2K = new ArrayList<>(Arrays.asList(k2_c1, k2_c2, k2_c3, k2_c4, k2_c5, k2_c6, k2_c7));

        flushBoard();
    }

    private void flushBoard()
    {
        populateHands();
        populateKingdoms();
        deckCounter.setText("Deck : " + String.valueOf(board.getDeck().getSize()));
    }

    private void populateHands()
    {
        for(int i =0; i<P1HAND.size(); i++)
        {
            if(i < board.getP1().getHand().getCardsInHand().size())
                P1HAND.get(i).setImage(getAppropriateImg(board.getP1().getHand().getCardsInHand().get(i)));
            else
                P1HAND.get(i).setImage(null);
        }

        for(int i =0; i<P2HAND.size(); i++)
        {
            if(i < board.getP2().getHand().getCardsInHand().size())
                P2HAND.get(i).setImage(getAppropriateImg(board.getP2().getHand().getCardsInHand().get(i)));
            else
                P2HAND.get(i).setImage(null);
        }
    }

    private void populateKingdoms()
    {
        for(int i =0; i<P1K.size(); i++)
        {
            if(i < board.getP1().getKingdom().getSize())
                P1K.get(i).setImage(getAppropriateImg(board.getP1().getKingdom().getCardsInKingdom().get(i)));
            else
                P1K.get(i).setImage(bottom);
        }

        for(int i =0; i<P2K.size(); i++)
        {
            if (i < board.getP2().getKingdom().getSize())
                P2K.get(i).setImage(getAppropriateImg(board.getP2().getKingdom().getCardsInKingdom().get(i)));
            else
                P2K.get(i).setImage(bottom);
        }
    }

    private Image getAppropriateImg(Card c)
    {
        if(c instanceof Dryad)
            return dry;
        else if(c instanceof Elf)
            return elf;
        else if(c instanceof Gnome)
            return gno;
        else if(c instanceof Goblin)
            return gob;
        else if(c instanceof Korrigan)
            return korr;
        else if(c instanceof Troll)
            return troll;
        else
            return null;
    }

    private void triggerCardSelection(ArrayList<ImageView> L, int index)
    {
        ColorAdjust glow = new ColorAdjust();
        glow.setBrightness(0.5);
        L.get(index).setEffect(glow);
        L.get(index).setCache(true);
        L.get(index).setCacheHint(CacheHint.SPEED);
        selectedCard = board.getP1().getHand().getCardsInHand().get(index);
    }

    private void untriggerCardSelection(ArrayList<ImageView> L, int index)
    {
        L.get(index).setEffect(null);
        selectedCard = null;
    }

    @FXML private void handleP1C1()
    {
        if(p1hand_c1.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 0);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(0))
            untriggerCardSelection(P1HAND, 0);
    }

    @FXML private void handleP1C2()
    {
        if(p1hand_c2.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 1);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(1))
            untriggerCardSelection(P1HAND, 1);
    }

    @FXML private void handleP1C3()
    {
        if(p1hand_c3.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 2);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(2))
            untriggerCardSelection(P1HAND, 2);
    }

    @FXML private void handleP1C4()
    {
        if(p1hand_c4.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 3);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(3))
            untriggerCardSelection(P1HAND, 3);
    }

    @FXML private void handleP1C5()
    {
        if(p1hand_c5.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 4);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(4))
            untriggerCardSelection(P1HAND, 4);
    }

    @FXML private void handleP1C6()
    {
        if(p1hand_c6.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 5);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(5))
            untriggerCardSelection(P1HAND, 5);
    }

    @FXML private void handleP1C7()
    {
        if(p1hand_c7.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 6);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(6))
            untriggerCardSelection(P1HAND, 6);
    }

    @FXML private void handleP1C8()
    {
        if(p1hand_c8.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 7);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(7))
            untriggerCardSelection(P1HAND, 7);
    }

    @FXML private void handleP1C9()
    {
        if(p1hand_c9.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 8);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(8))
            untriggerCardSelection(P1HAND, 8);
    }

    @FXML private void handleP1C10()
    {
        if(p1hand_c10.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 9);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(9))
            untriggerCardSelection(P1HAND, 9);
    }
}