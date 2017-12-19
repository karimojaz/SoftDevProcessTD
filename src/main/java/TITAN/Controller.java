package TITAN;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private Board board;
    private ArrayList<ImageView> P1HAND, P2HAND, P1K, P2K;
    private Image dry, elf, gno, gob, korr, troll, bottom, karimlafolle;
    private Card selectedCard;
    private int selectedCardIndex;
    private boolean lastTurn;

    //All the ImageViews
    @FXML private ImageView p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10, p1hand_c11, p1hand_c12, p1hand_c13, p1hand_c14, p1hand_c15, p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10, p2hand_c11, p2hand_c12, p2hand_c13, p2hand_c14, p2hand_c15, k1_c1, k1_c2, k1_c3, k1_c4, k1_c5, k1_c6, k1_c7, k1_c8, k1_c9, k1_c10, k1_c11, k1_c12, k1_c13, k1_c14, k1_c15, k1_c16, k1_c17, k1_c18, k1_c19, k2_c1, k2_c2, k2_c3, k2_c4, k2_c5, k2_c6, k2_c7, k2_c8, k2_c9, k2_c10, k2_c11, k2_c12, k2_c13, k2_c14, k2_c15, k2_c16, k2_c17, k2_c18, k2_c19;
    @FXML private Label deckCounter, currentPlayerLabel, p1Score, p2Score;

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
        karimlafolle = new Image(new File("resources/image/DosDeCarte.png").toURI().toString());

        selectedCard = null;
        selectedCardIndex = -1;
        lastTurn = false;
    }

    @FXML public void initialize(URL location, ResourceBundle resources)
    {
        P1HAND = new ArrayList<>(Arrays.asList(p1hand_c1, p1hand_c2, p1hand_c3, p1hand_c4, p1hand_c5, p1hand_c6, p1hand_c7, p1hand_c8, p1hand_c9, p1hand_c10, p1hand_c11, p1hand_c12, p1hand_c13, p1hand_c14, p1hand_c15));
        P2HAND = new ArrayList<>(Arrays.asList(p2hand_c1, p2hand_c2, p2hand_c3, p2hand_c4, p2hand_c5, p2hand_c6, p2hand_c7, p2hand_c8, p2hand_c9, p2hand_c10, p2hand_c11, p2hand_c12, p2hand_c13, p2hand_c14, p2hand_c15));
        P1K = new ArrayList<>(Arrays.asList(k1_c1, k1_c2, k1_c3, k1_c4, k1_c5, k1_c6, k1_c7, k1_c8, k1_c9, k1_c10, k1_c11, k1_c12, k1_c13, k1_c14, k1_c15, k1_c16, k1_c17, k1_c18, k1_c19));
        P2K = new ArrayList<>(Arrays.asList(k2_c1, k2_c2, k2_c3, k2_c4, k2_c5, k2_c6, k2_c7, k2_c8, k2_c9, k2_c10, k2_c11, k2_c12, k2_c13, k2_c14, k2_c15, k2_c16, k2_c17, k2_c18, k2_c19));

        flushBoard();
    }

    private void flushBoard()
    {
        populateKingdoms();
        deckCounter.setText("Deck : " + String.valueOf(board.getDeck().getSize()));
        currentPlayerLabel.setText("Player " + (board.getActivePlayer() == board.getP1() ? "1" : "2") + "'s turn");
        board.getP1().calculateScore();
        board.getP2().calculateScore();
        p1Score.setText("Score : " + String.valueOf(board.getP1().getScore()));
        p2Score.setText("Score : " + String.valueOf(board.getP2().getScore()));

        if(lastTurn || board.getActivePlayer().getHand().getSize() == 0)
        {
            int s1 = board.getP1().getScore();
            int s2 = board.getP2().getScore();

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("TITAN GAME");
            a.setHeaderText("Game Over !");
            a.setContentText("Player " + (s1 > s2 ? "1" : "2") + " wins the game !");
            a.showAndWait();

            Platform.exit();
            System.exit(0);
        }

        populateHands();

        if(board.getInactivePlayer().getHand().getSize() == 0)
            lastTurn = true;
    }

    private void populateHands()
    {
        for(int i =0; i<P1HAND.size(); i++)
        {
            if(i < board.getP1().getHand().getCardsInHand().size())
                P1HAND.get(i).setImage(board.getActivePlayer() == board.getP1() ? getAppropriateImg(board.getP1().getHand().getCardsInHand().get(i)) : karimlafolle);
            else
                P1HAND.get(i).setImage(null);
        }

        for(int i =0; i<P2HAND.size(); i++)
        {
            if(i < board.getP2().getHand().getCardsInHand().size())
                P2HAND.get(i).setImage(board.getActivePlayer() == board.getP2() ? getAppropriateImg(board.getP2().getHand().getCardsInHand().get(i)) : karimlafolle);
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
        selectedCard = board.getActivePlayer().getHand().getCardsInHand().get(index);
        selectedCardIndex = index;
    }

    private void untriggerCardSelection(ArrayList<ImageView> L, int index)
    {
        L.get(index).setEffect(null);
        selectedCard = null;
        selectedCardIndex = -1;
    }

    public int chooseCardFromOpponentKingdom()
    {
        ArrayList<String> choices = new ArrayList<>();
        for(int i = 0; i<board.getInactivePlayer().getKingdom().getSize();i++)
        {
            choices.add(String.valueOf(i+1) + " : " + board.getInactivePlayer().getKingdom().getCardsInKingdom().get(i).toString());
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>("1 : " + board.getInactivePlayer().getKingdom().getCardsInKingdom().get(0).toString(), choices);
        dialog.setTitle("TITAN GAME");
        dialog.setHeaderText("Choose a card from your opponent's kingdom to steal it !");
        dialog.setContentText("Card :");

        Optional<String> res;

        do
        {
            res = dialog.showAndWait();
        }while(!res.isPresent());

        return Integer.parseInt(res.get().substring(0,1)) - 1;
    }

    public int chooseCardFromOwnKingdom()
    {
        ArrayList<String> choices = new ArrayList<>();
        for(int i = 0; i<board.getActivePlayer().getKingdom().getSize();i++)
        {
            choices.add(String.valueOf(i+1) + " : " + board.getActivePlayer().getKingdom().getCardsInKingdom().get(i).toString());
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>("1 : " + board.getActivePlayer().getKingdom().getCardsInKingdom().get(0).toString(), choices);
        dialog.setTitle("TITAN GAME");
        dialog.setHeaderText("Choose a card from your kingdom to copy its effect !");
        dialog.setContentText("Card :");

        Optional<String> res;

        do
        {
            res = dialog.showAndWait();
        }while(!res.isPresent());

        return Integer.parseInt(res.get().substring(0,1)) - 1;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////HANDLERS FOR EACH CARD'S IMAGEVIEW IN HAND CLICK.//////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML private void handleP1C1()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c1.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 0);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(0))
            untriggerCardSelection(P1HAND, 0);
    }

    @FXML private void handleP1C2()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c2.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 1);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(1))
            untriggerCardSelection(P1HAND, 1);
    }

    @FXML private void handleP1C3()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c3.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 2);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(2))
            untriggerCardSelection(P1HAND, 2);
    }

    @FXML private void handleP1C4()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c4.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 3);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(3))
            untriggerCardSelection(P1HAND, 3);
    }

    @FXML private void handleP1C5()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c5.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 4);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(4))
            untriggerCardSelection(P1HAND, 4);
    }

    @FXML private void handleP1C6()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c6.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 5);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(5))
            untriggerCardSelection(P1HAND, 5);
    }

    @FXML private void handleP1C7()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c7.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 6);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(6))
            untriggerCardSelection(P1HAND, 6);
    }

    @FXML private void handleP1C8()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c8.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 7);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(7))
            untriggerCardSelection(P1HAND, 7);
    }

    @FXML private void handleP1C9()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c9.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 8);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(8))
            untriggerCardSelection(P1HAND, 8);
    }

    @FXML private void handleP1C10()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c10.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 9);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(9))
            untriggerCardSelection(P1HAND, 9);
    }

    @FXML private void handleP1C11()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c11.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 10);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(10))
            untriggerCardSelection(P1HAND, 10);
    }

    @FXML private void handleP1C12()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c12.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 11);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(11))
            untriggerCardSelection(P1HAND, 11);
    }

    @FXML private void handleP1C13()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c13.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 12);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(12))
            untriggerCardSelection(P1HAND, 12);
    }

    @FXML private void handleP1C14()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c14.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 13);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(13))
            untriggerCardSelection(P1HAND, 13);
    }

    @FXML private void handleP1C15()
    {
        if(board.getActivePlayer() != board.getP1())
            return;
        if(p1hand_c15.getImage() != null && selectedCard == null)
            triggerCardSelection(P1HAND, 14);
        else if(selectedCard == board.getP1().getHand().getCardsInHand().get(14))
            untriggerCardSelection(P1HAND, 14);
    }

    @FXML private void handleP2C1()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c1.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 0);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(0))
            untriggerCardSelection(P2HAND, 0);
    }

    @FXML private void handleP2C2()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c2.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 1);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(1))
            untriggerCardSelection(P2HAND, 1);
    }

    @FXML private void handleP2C3()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c3.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 2);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(2))
            untriggerCardSelection(P2HAND, 2);
    }

    @FXML private void handleP2C4()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c4.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 3);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(3))
            untriggerCardSelection(P2HAND, 3);
    }

    @FXML private void handleP2C5()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c5.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 4);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(4))
            untriggerCardSelection(P2HAND, 4);
    }

    @FXML private void handleP2C6()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c6.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 5);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(5))
            untriggerCardSelection(P2HAND, 5);
    }

    @FXML private void handleP2C7()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c7.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 6);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(6))
            untriggerCardSelection(P2HAND, 6);
    }

    @FXML private void handleP2C8()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c8.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 7);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(7))
            untriggerCardSelection(P2HAND, 7);
    }

    @FXML private void handleP2C9()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c9.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 8);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(8))
            untriggerCardSelection(P2HAND, 8);
    }

    @FXML private void handleP2C10()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c10.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 9);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(9))
            untriggerCardSelection(P2HAND, 9);
    }

    @FXML private void handleP2C11()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c11.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 10);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(10))
            untriggerCardSelection(P2HAND, 10);
    }

    @FXML private void handleP2C12()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c12.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 11);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(11))
            untriggerCardSelection(P2HAND, 11);
    }

    @FXML private void handleP2C13()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c13.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 12);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(12))
            untriggerCardSelection(P2HAND, 12);
    }

    @FXML private void handleP2C14()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c14.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 13);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(13))
            untriggerCardSelection(P2HAND, 13);
    }

    @FXML private void handleP2C15()
    {
        if(board.getActivePlayer() != board.getP2())
            return;
        if(p2hand_c15.getImage() != null && selectedCard == null)
            triggerCardSelection(P2HAND, 14);
        else if(selectedCard == board.getP2().getHand().getCardsInHand().get(14))
            untriggerCardSelection(P2HAND, 14);
    }

    @FXML private void handleK1()
    {
        if(board.getActivePlayer() != board.getP1())
            return;

        if(selectedCard != null)
        {
            board.getActivePlayer().playCard(selectedCardIndex, this);
            untriggerCardSelection(P1HAND, selectedCardIndex);
            board.newTurn();
        }

        flushBoard();
    }

    @FXML private void handleK2()
    {
        if(board.getActivePlayer() != board.getP2())
            return;

        if(selectedCard != null)
        {
            board.getActivePlayer().playCard(selectedCardIndex, this);
            untriggerCardSelection(P2HAND, selectedCardIndex);
            board.newTurn();
        }

        flushBoard();
    }
}