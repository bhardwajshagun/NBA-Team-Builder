import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class NBADatabaseMySQL {

  // For demonstration purposes. Better would be a constructor that takes a file path
  // and loads parameters dynamically.
  DBUtils dbu;

  public void authenticate(String user, String password) {
    dbu = new DBUtils("jdbc:mysql://localhost:3306/nba?serverTimezone=EST5EDT", user, password);
  }

  /**
   * Close the connection when application finishes
   */
  public void closeConnection() { dbu.closeConnection(); }

  /**
   * Get or insert on specialty term
   * @param test The name of the hospital
   * @return ID of a new or existing hospital.
   */
  public int getOrInsertPlaystyle(String test)
  {
    return dbu.getTest("play_style", "play_style_id", "play_style_name", test);
  }

  public int getNumPlayers() {
    return dbu.getCount("player");
  }

  public int[] getPositionPlayers(String position, int size) {
    return dbu.getPosition(position, size);
  }

  public int getNumPositions(String position){
    return dbu.numPositions(position);
  }

}
