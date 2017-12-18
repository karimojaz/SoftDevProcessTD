package TITAN;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class
App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("TITAN GAME");
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/WelcomPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();

        WelcomeController wctrl = loader.getController();
        wctrl.setWelcomeStage(primaryStage);

       //Game g = new Game();
       // g.play();
    }
}
