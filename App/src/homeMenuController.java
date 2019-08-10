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

  // text boxes (labels) of names that will be populated with players' names who are already on the
  // user's team
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
  private Label bench6;
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
  // Uses existing roster (which has been stored and returned as an array of strings of players)
  // we'll need a helper function to get the actual player id's from the database
  @FXML
  private Button recommendPlayers;

  // our three buttons which will represent the user's choice for which player to add to the team
  @FXML
  private Button addFirstRecommendedPlayer;
  @FXML
  private Button addSecondRecommendedPlayer;
  @FXML
  private Button addThirdRecommendedPlayer;

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

    // now set the player names on the left hand side, displaying user's current team members
    // use a try/catch block when attempting to add the player's photo
    starter1.setText(currentRoster.get(0));
    try {
      Image image1 = new Image("pictures/photos/" + currentRoster.get(0) + ".png");
      player1pic.setImage(image1);
    } catch (Exception e) {
    }

    starter2.setText(currentRoster.get(1));
    try {
      Image image2 = new Image("pictures/photos/" + currentRoster.get(1) + ".png");
      player2pic.setImage(image2);
    } catch (Exception e) {
    }

    starter3.setText(currentRoster.get(2));
    try {
      Image image3 = new Image("pictures/photos/" + currentRoster.get(2) + ".png");
      player3pic.setImage(image3);
    } catch (Exception e) {
    }

    starter4.setText(currentRoster.get(3));
    try {
      Image image4 = new Image("pictures/photos/" + currentRoster.get(3) + ".png");
      player4pic.setImage(image4);
    } catch (Exception e) {
    }

    starter5.setText(currentRoster.get(4));
    try {
      Image image5 = new Image("pictures/photos/" + currentRoster.get(4) + ".png");
      player5pic.setImage(image5);
    } catch (Exception e) {
    }

    // and add any bench players (if they exist!)
    bench1.setText(currentRoster.get(5));
    bench2.setText(currentRoster.get(6));
    bench3.setText(currentRoster.get(7));
    bench4.setText(currentRoster.get(8));
    bench5.setText(currentRoster.get(9));
    bench6.setText(currentRoster.get(10));
  }


  // here, depending on what the user selects for goal, position, and desired salary, the correct
  // algorithm runs which runs a series of queries and returns the top 3 potential targets
  @FXML
  void runRecommendationAlgorithm(ActionEvent event) {
    String[] players;
    if (potentialGoals.getValue().equals("Championship")) {
      if (targetPositions.getValue().equals("PG")) {
        players = nba.getChampionshipPGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SG")) {
        players = nba.getChampionshipSGs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("SF")) {
        players = nba.getChampionshipSFs(maxContracts.getValue());
      } else if (targetPositions.getValue().equals("PF")) {
        players = nba.getChampionshipPFs(maxContracts.getValue());
      } else {
        players = nba.getChampionshipCs(maxContracts.getValue());
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
    } else {
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
    String[] recommendedPlayers = new String[3];
    int counter = 0;
    int i = 0;
    while (counter < 3) {
      if (!roster.contains(players[i])) {
        recommendedPlayers[counter] = players[i];
        counter++;
      }
      i++;
    }

    // here we set the labels in the GUI to list the three recommended players...the user can then
    // select one and that player will be added to the current roster (the left hand side of GUI)
    recommendation1.setText(recommendedPlayers[0]);
    try {
      Image image1 = new Image("pictures/photos/" + recommendation1.getText() + ".png");
      recommend1pic.setImage(image1);
    } catch (Exception e) {
    }
    recommendation2.setText(recommendedPlayers[1]);
    try {
      Image image1 = new Image("pictures/photos/" + recommendation2.getText() + ".png");
      recommend2pic.setImage(image1);
    } catch (Exception e) {
    }
    recommendation3.setText(recommendedPlayers[2]);
    try {
      Image image1 = new Image("pictures/photos/" + recommendation3.getText() + ".png");
      recommend3pic.setImage(image1);
    } catch (Exception e) {
    }
  }

  // the below three action event handlers will add the user's choice to our current team
  // each one calls a helper function that will see where the empty player slot is and add the
  // player there
  @FXML
  void addFirstSelection(ActionEvent event) {
    System.out.println("Added the first recommendation.");
    findRosterSlot(recommendation1.getText());
  }

  @FXML
  void addSecondSelection(ActionEvent event) {
    System.out.println("Added the second recommendation.");
    findRosterSlot(recommendation2.getText());
  }

  @FXML
  void addThirdSelection(ActionEvent event) {
    System.out.println("Added the third recommendation.");
    findRosterSlot(recommendation3.getText());
  }

  // helper method to add selected player
  void findRosterSlot(String playerToAdd) {
    System.out.println("We're adding to the team: " + playerToAdd);

    // lots of conditionals to see which roster slots are already full and add player to the next
    // available roster spot along with their picture (if it's a starter)
    if (starter1.getText().equals("")) {
      System.out.println("Slot one is empty, adding player here.");
      starter1.setText(playerToAdd);
      try {
        Image image1 = new Image("pictures/photos/" + playerToAdd + ".png");
        player1pic.setImage(image1);
      } catch (Exception e) {
      }
    } else if (starter2.getText().equals("")) {
      System.out.println("Slot two is empty, adding player here.");
      starter2.setText(playerToAdd);
      try {
        Image image2 = new Image("pictures/photos/" + playerToAdd + ".png");
        player2pic.setImage(image2);
      } catch (Exception e) {
      }
    } else if (starter3.getText().equals("")) {
      System.out.println("Slot three is empty, adding player here.");
      starter3.setText(playerToAdd);
      try {
        Image image3 = new Image("pictures/photos/" + playerToAdd + ".png");
        player3pic.setImage(image3);
      } catch (Exception e) {
      }
    } else if (starter4.getText().equals("")) {
      System.out.println("Slot four is empty, adding player here.");
      starter4.setText(playerToAdd);
      try {
        Image image4 = new Image("pictures/photos/" + playerToAdd + ".png");
        player4pic.setImage(image4);
      } catch (Exception e) {
      }
    } else if (starter5.getText().equals("")) {
      System.out.println("Slot five is empty, adding player here.");
      starter5.setText(playerToAdd);
      try {
        Image image5 = new Image("pictures/photos/" + playerToAdd + ".png");
        player5pic.setImage(image5);
      } catch (Exception e) {
      }
    } else if (bench1.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench one is empty, adding player here.");
      bench1.setText(playerToAdd);
    } else if (bench2.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench two is empty, adding player here.");
      bench2.setText(playerToAdd);
    } else if (bench3.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench three is empty, adding player here.");
      bench3.setText(playerToAdd);
    } else if (bench4.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench four is empty, adding player here.");
      bench4.setText(playerToAdd);
    } else if (bench5.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench five is empty, adding player here.");
      bench5.setText(playerToAdd);
    } else if (bench6.getText().equals("")) { // it's not a starter, so check the bench spots
      System.out.println("Bench six is empty, adding player here.");
      bench6.setText(playerToAdd);
    }
  }
}


