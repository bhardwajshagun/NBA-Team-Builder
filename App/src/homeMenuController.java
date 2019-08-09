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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


// this will be our controller for the window that runs with all updated current rosters after the
// user has inputted them
public class homeMenuController implements Initializable {

  private static NBATeamBuilder nba = new NBATeamBuilder();

  // list of all possible goals that will be used in the dropdown menu in the GUI
  private ObservableList<String> goalNames = FXCollections.observableArrayList(
          "Championship", "Tank", "Build for Future");
  // list of possible positions to target
  private ObservableList<String> positions = FXCollections.observableArrayList(
          "PG", "SG", "SF", "PF", "C");
  // list of ranges of salaries for target players
  private ObservableList<Integer> salaries = FXCollections.observableArrayList(
          5000000, 10000000, 15000000, 20000000, 25000000, 30000000, 35000000, 40000000, 50000000);

  @FXML
  private GridPane starters;

  // text boxes (labels) of player names that will be populated with players' names
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
  @FXML
  private Label recommendation1;
  @FXML
  private Label recommendation2;
  @FXML
  private Label recommendation3;

  // image view FXML objects that will be populated with players' pics (if we have time for this)
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
  @FXML
  private ImageView recommend1pic;
  @FXML
  private ImageView recommend2pic;
  @FXML
  private ImageView recommend3pic;

  // dropdown menu for our different team goals that the user can pick from
  @FXML
  private ChoiceBox<String> potentialGoals;
  // dropdown menu for the 5 different positions the user can target
  @FXML
  private ChoiceBox<String> targetPositions;
  // dropdown menu for the different ranges of salary the user is willing to pay
  @FXML
  private ChoiceBox<Integer> maxContracts;

  // button that will run the "algorithm" that you guys have been building
  // taking into consideration the salary cap (still need to do this piece)
  // and existing roster (which has been stored and returned as an array of strings of player names
  // we'll need a helper function to get the actual player id's from the database
  @FXML
  private Button recommendPlayers;

  private ArrayList<String> roster;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    potentialGoals.setItems(goalNames);
    targetPositions.setItems(positions);
    maxContracts.setItems(salaries);
  }

  // initialize the window now that we have the current roster inputted by the user
  void initData(ArrayList<String> currentRoster) {

    roster = currentRoster;

    // first need to do some sanity checks, to see if the user has even entered any players
    if (currentRoster.isEmpty()) {
      System.out.println("No players currently on the roster.\n");
    }

    for (int i = 0; i < currentRoster.size(); i++) {
      System.out.println(currentRoster.get(i));
    }

    // now set the player names on the left hand side, displaying user's current team members
    // may need to implement a try/catch here depending on what it does for empty array elements...
    System.out.println("Adding first starter...." + currentRoster.get(0) + "\n");
    starter1.setText(currentRoster.get(0));
    try {
      Image image1 = new Image("pictures/photos/" + currentRoster.get(0) + ".png");
      player1pic.setImage(image1);
    } catch (Exception e) {
    }

    System.out.println("Adding second starter...." + currentRoster.get(1) + "\n");
    starter2.setText(currentRoster.get(1));
    try {
      Image image2 = new Image("pictures/photos/" + currentRoster.get(1) + ".png");
      player2pic.setImage(image2);
    } catch (Exception e) {
    }

    System.out.println("Adding third starter...." + currentRoster.get(2) + "\n");
    starter3.setText(currentRoster.get(2));
    try {
      Image image3 = new Image("pictures/photos/" + currentRoster.get(2) + ".png");
      player3pic.setImage(image3);
    } catch (Exception e) {
    }

    System.out.println("Adding fourth starter...." + currentRoster.get(3) + "\n");
    starter4.setText(currentRoster.get(3));
    try {
      Image image4 = new Image("pictures/photos/" + currentRoster.get(3) + ".png");
      player4pic.setImage(image4);
    } catch (Exception e) {
    }

    System.out.println("Adding fifth starter...." + currentRoster.get(4) + "\n");
    starter5.setText(currentRoster.get(4));
    try {
      Image image5 = new Image("pictures/photos/" + currentRoster.get(4) + ".png");
      player5pic.setImage(image5);
    } catch (Exception e) {
    }

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
    System.out.println("targetposition: " + targetPositions.getValue());
    System.out.println("potentialGoals: " + potentialGoals.getValue());
    String[] players = new String[3];
    if (potentialGoals.getValue().equals("Championship")) {
      if (targetPositions.getValue().equals("PG")) {

      } else if (targetPositions.getValue().equals("SG")) {

      } else if (targetPositions.getValue().equals("SF")) {

      } else if (targetPositions.getValue().equals("PF")) {

      } else {

      }
    } else if (potentialGoals.getValue().equals("Tank")) {
      if (targetPositions.getValue().equals("PG")) {
        players = nba.getTankPGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SG")) {
        players = nba.getTankSGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SF")) {
        players = nba.getTankSFs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("PF")) {
        players = nba.getTankPFs(maxContracts.getValue());
      } else {
        players = nba.getTankCs(maxContracts.getValue());
      }
    }
    else {
      if (targetPositions.getValue().equals("PG")) {
        players = nba.getFuturePGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SG")) {
        players = nba.getFutureSGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SF")) {
        players = nba.getFutureSFs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("PF")) {
        players = nba.getFuturePFs(maxContracts.getValue());
      } else {
        players = nba.getFutureCs(maxContracts.getValue());
      }
    }
    recommendation1.setText(players[0]);
    recommendation2.setText(players[1]);
    recommendation3.setText(players[2]);
  }
}