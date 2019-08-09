package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HomeController implements Initializable {

  // button that user will hit at the start to enter existing roster players
  @FXML
  private Button inputCurrentRoster;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  // this will attempt to open a second window (inputRoster) where user enters current players
  @FXML
  void handleInputCurrentRoster(ActionEvent event) {

    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inputRoster.fxml"));
      Parent inputRoot = fxmlLoader.load();
      Stage stage = new Stage();
      stage.initStyle(StageStyle.DECORATED);
      stage.setTitle("Input Current Roster");
      stage.setScene(new Scene(inputRoot));
      stage.show();
    } catch (Exception e) {
      System.out.println("Unable to load inputRoster window.");
    }
  }


}
