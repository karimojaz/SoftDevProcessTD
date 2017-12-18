package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private Board board;

    public Controller()
    {
        board = new Board();
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
