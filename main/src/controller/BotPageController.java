package src.controller;

import org.openqa.selenium.WebDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotPageController {

  @FXML Button like;
  @FXML TextField hashtagField;
  @FXML TextField anzahlField;
  @FXML TextField sekundenField;

  private WebBrowserDriver driver;

  @FXML
  private void likeAction(ActionEvent event) {
    //like.setDisable(true);

    driver = new WebBrowserDriver();
    driver.like(hashtagField.getText(),Integer.parseInt(anzahlField.getText()), Integer.parseInt(sekundenField.getText()));
  }

}
