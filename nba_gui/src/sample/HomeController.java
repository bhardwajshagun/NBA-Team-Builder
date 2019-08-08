package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable {

  // a variable that will be used to store the current roster after user enters it
  public ArrayList<String> currentRosterFromInput = new ArrayList<>();

  // list of all possible goals that will be used in the dropdown menu in the GUI
  private ObservableList<String> goalNames = FXCollections.observableArrayList(
          "Win the championship", "Tank for draft picks", "Stockpile assets");

  // button that user will hit at the start to enter existing roster players
  @FXML
  private Button inputCurrentRoster;
  @FXML
  private GridPane starters;

  // 5 text boxes of player names that will be populated with starters' names
  // NOT WORKING RIGHT NOW - CAN'T GET TO UPDATE AFTER RETURNING ARRAY LIST
  @FXML
  private TextField player1;
  @FXML
  private TextField player2;
  @FXML
  private TextField player3;
  @FXML
  private TextField player4;
  @FXML
  private TextField player5;

  // 5 image view FXML objects that will be populated with starters' pics (if we have time for this)
  @FXML
  private ImageView player1pic;
  @FXML
  private ImageView player2pic;
  @FXML
  private ImageView player3pic;
  @FXML
  private ImageView player4pic;
  @FXML
  private ImageView player5pic;

  // dropdown menu for our different team goals that the user can pick from
  @FXML
  private ChoiceBox<String> potentialGoals;

  // button that will run the "algorithm" that you guys have been building
  // taking into consideration the salary cap (still need to do this piece)
  // and existing roster (which has been stored and returned as an array of strings of player names
  // we'll need a helper function to get the actual player id's from the database
  @FXML
  private Button recommendPlayers;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    potentialGoals.setItems(goalNames);
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

  // helper method which will be called by inputRosterController to pass current roster back to the Home Controller
  void getCurrentRoster(ArrayList<String> currentRoster) {
    currentRosterFromInput = currentRoster;
    setCurrentRoster();
  }

  private void setCurrentRoster() {
    // here we are taking the current roster returned from the inputRosterController
    // and filling in the main window with the user's current team
    System.out.println("Back in HomeController in setCurrentRoster...printing array as a test\n");

    for (String player : currentRosterFromInput) {
      System.out.println(player);
    }

    // THIS IS CURRENTLY NOT WORKING...not sure why the text field boxes won't update
    // almost positive setText is the function that we need to use

    // now we have our array list of players...need to find the count and add them to the GUI
    // start with the first 5 players added, which are the team's starters
    player1.setText(currentRosterFromInput.get(1));
    player2.setText(currentRosterFromInput.get(2));
    player3.setText(currentRosterFromInput.get(3));
    player4.setText(currentRosterFromInput.get(4));
    player5.setText(currentRosterFromInput.get(5));

    // and then add all the bench players
    // .........

    // and add each of their pics to the corresponding ImageView objects
  }

  @FXML
  void runRecommendationAlgorithm(ActionEvent event) {


    // !!!!!!!
    // THIS IS WHERE THE MAGIC HAPPENS BABY
    // !!!!!!!


  }
}
