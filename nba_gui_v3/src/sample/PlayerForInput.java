package sample;

import javafx.beans.property.SimpleStringProperty;

public class PlayerForInput {

  private final SimpleStringProperty playerName;

  public PlayerForInput(String playerName) {
    this.playerName = new SimpleStringProperty(playerName);
  }

  public String getPlayerName() {
    return playerName.get();
  }

  public void setPlayerName(String name) {
    playerName.set(name);
  }

}
