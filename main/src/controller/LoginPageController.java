package src.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.Bot;

public class LoginPageController {

  @FXML Button loginButton;
  @FXML TextField usernameField;
  @FXML TextField passwordField;

  @FXML
  private void loginAction(ActionEvent event) throws Exception {
    loginButton.setDisable(true);
    WebBrowserDriver wbd = new WebBrowserDriver();
   // wbd.datenUebergabe(usernameField.getText(), passwordField.getText());
    wbd.datenUebergabe("david_pawellek", "itaka--143");
    wbd.starteBrowser();
    wbd.login();
    Stage stage = (Stage) loginButton.getScene().getWindow();
    stage.close();
    Bot b = new Bot();
    Stage stage2 = new Stage();
    b.start(stage2);
   }
}