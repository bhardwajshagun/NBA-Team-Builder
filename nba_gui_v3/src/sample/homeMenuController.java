package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


// this will be our controller for the window that runs with all updated current rosters after the
// user has inputted them
public class homeMenuController implements Initializable {

  // list of all possible goals that will be used in the dropdown menu in the GUI
  private ObservableList<String> goalNames = FXCollections.observableArrayList(
          "Win the championship", "Tank for draft picks", "Stockpile assets");

  @FXML
  private GridPane starters;

  // 5 text boxes of player names that will be populated with starters' names
  // NOT WORKING RIGHT NOW - CAN'T GET TO UPDATE AFTER RETURNING ARRAY LIST
  @FXML
  private Label starter1;
  @FXML
  private Label starter2;
  @FXML
  private Label starter3;
  @FXML
  private Label starter4;
  @FXML
  private Label starter5;
  @FXML
  private Label bench1;
  @FXML
  private Label bench2;
  @FXML
  private Label bench3;
  @FXML
  private Label bench4;
  @FXML
  private Label bench5;

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

  // initialize the window now that we have the current roster inputted by the user
  void initData(ArrayList<String> currentRoster) {

    // first need to do some sanity checks, to see if the user has even entered any players
    if (currentRoster.isEmpty()) {
      System.out.println("No players currently on the roster.\n");
    }

    // now set the player names on the left hand side, displaying user's current team members
    // may need to implement a try/catch here depending on what it does for empty array elements...
    System.out.println("Adding first starter...." + currentRoster.get(0) + "\n");
    starter1.setText(currentRoster.get(0));
    System.out.println("Adding second starter...." + currentRoster.get(1) + "\n");
    starter2.setText(currentRoster.get(1));
    System.out.println("Adding third starter...." + currentRoster.get(2) + "\n");
    starter3.setText(currentRoster.get(2));
    System.out.println("Adding fourth starter...." + currentRoster.get(3) + "\n");
    starter4.setText(currentRoster.get(3));
    System.out.println("Adding fifth starter...." + currentRoster.get(4) + "\n");
    starter5.setText(currentRoster.get(4));

    System.out.println("Now setting labels for bench players too");
    // and add any bench players (if they exist!)
    bench1.setText(currentRoster.get(5));
    bench1.setText(currentRoster.get(6));
    bench1.setText(currentRoster.get(7));
    bench1.setText(currentRoster.get(8));
    bench1.setText(currentRoster.get(9));


  }

  @FXML
  void runRecommendationAlgorithm(ActionEvent event) {


    // !!!!!!!
    // THIS IS WHERE THE MAGIC HAPPENS BABY
    // !!!!!!!


  }


}