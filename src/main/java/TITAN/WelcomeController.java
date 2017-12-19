package TITAN;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable
{
    private Stage welcomeStage;

    @FXML public void Change()
    {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TITAN GAME");
        Parent root = null;
        try {
            root = FXMLLoader.load(WelcomeController.class.getResource("/fxml/Game.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        welcomeStage.close();
        primaryStage.show();
    }

    public void setWelcomeStage(Stage s)
    {
        welcomeStage = s;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
