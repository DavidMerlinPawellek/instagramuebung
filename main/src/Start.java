package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
    primaryStage.setTitle("Login Page");

    Scene scene = new Scene(root, 370, 500);
    primaryStage.setScene(scene);

    primaryStage.setX(2750);
    primaryStage.setY(300);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

