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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class inputRosterController implements Initializable {

  // HERE WE NEED TO PUT A LIST OF ALL THE ACTIVE PLAYERS NAMES
  private ObservableList<String> playerList = FXCollections.observableArrayList("Kevin Durant",
          "Lebron James", "Kyrie Irving");

  @FXML
  private TitledPane titlePane;

  @FXML
  private Pane pane;

  @FXML
  private ComboBox<String> allPlayers;

  @FXML
  private Label selectPlayerName;

  @FXML
  private Button addSelectedPlayer;

  @FXML
  private Button doneAddingPlayers;

  @FXML
  private TableView<PlayerForInput> listOfPlayers;

  @FXML
  private TableColumn<PlayerForInput, String> playerName;

  private final ObservableList<PlayerForInput> players = FXCollections.observableArrayList();

  public ArrayList<String> finalRoster = new ArrayList<>();


  // initialize our ComboBox with the list of all players from our database
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // HERE EVENTUALLY ADD THE FIRST NAME ALPHABETICALLY!!
    allPlayers.setValue("Lebron James");
    allPlayers.setItems(playerList);

    // set the cell values for the playerName column in the tableView
    playerName.setCellValueFactory(
            new PropertyValueFactory<PlayerForInput, String>("playerName"));
  }


  @FXML
  void handleAddSelectedPlayer(ActionEvent event) {
    // when the user clicks addPlayer, we want to move the selected player over to the table
    // first take the String name and create a PlayerForInput object
    PlayerForInput newPlayer = new PlayerForInput(allPlayers.getValue());
    newPlayer.setPlayerName(allPlayers.getValue());

    int existing = 0;

    // we're going to add this player, but first we need to check if he is already on the team
    for (String player : finalRoster) {
      System.out.println("checking again");
      if (player.equals(allPlayers.getValue())) {
        System.out.println("player " + player + " is already on team!");
        existing = 1;
      }
    }

    if (existing != 1) {
      // otherwise we add them to our Observable list and then add to our team!
      players.add(newPlayer);
      listOfPlayers.setItems(players);
      // and add the player to our array list 'final roster' which will be passed to homeMenu
      finalRoster.add(allPlayers.getValue());
    }
  }

  @FXML
  void handleDoneAddingPlayers(ActionEvent event) {
    // when the user is done adding players to their current roster, return an array of the player names
    // to a new controller and menu

    // start by creating a HomeController and calling a function in it
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("homeMenu.fxml"));
      Parent inputRoot = loader.load();

      Stage stage = new Stage();
      stage.initStyle(StageStyle.DECORATED);
      stage.setScene(new Scene(inputRoot));
      stage.show();
      // create the homeMenuController object here, so that we can directly pass the current roster
      // to the new controller so it can use that data
      homeMenuController controller = loader.getController();
      controller.initData(finalRoster);

    } catch (Exception e) {
      System.out.println("Error passing current roster to the new controller.");
    }
  }


}
