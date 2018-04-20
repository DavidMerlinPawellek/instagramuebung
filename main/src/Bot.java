package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bot extends Application {

  @Override
  public void start(final Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("botPage.fxml"));
    primaryStage.setTitle("Bot");

    Scene scene = new Scene(root, 570, 500);
    primaryStage.setScene(scene);

    primaryStage.setX(2750);
    primaryStage.setY(300);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

