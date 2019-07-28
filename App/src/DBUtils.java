import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class DBUtils {


  private String url;
  private String user;
  private String password;
  private Connection con = null;

  public DBUtils(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
    this.con = getConnection();
  }

  public Connection getConnection()
  {
    if (con == null) {
      try {
        con = DriverManager.getConnection(url, user, password);
        return con;
      } catch (SQLException e) {
        System.err.println(e.getMessage());
        System.exit(1);
      }
    }
    return con;
  }

  public void closeConnection() {
    try {
      con.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * For a table of terms consisting of an id and string value pair, get the id of the term
   * adding a new term if it does not yet exist in the table
   * @param table The table of terms
   * @param term The term value
   * @return The id of the term
   */
  public int getTest(String table, String keyColumn, String valueColumn, String term)
  {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "SELECT "+keyColumn+" FROM "+table+" WHERE "+valueColumn+" = '"+term.toUpperCase()+"'";
      ResultSet rs = stmt.executeQuery(sqlGet);
      if (rs.next())
        key = rs.getInt(1);
      else {
        String sqlInsert = "INSERT INTO "+table+" ("+valueColumn+") VALUES ('"+term.toUpperCase()+"')";
        stmt.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
        if (rs.next()) key = rs.getInt(1);
      }
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return key;
  }

  public int getCount(String table) {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "SELECT COUNT(*) as total FROM " + table;
      ResultSet rs = stmt.executeQuery(sqlGet);
      rs.next();
      key = rs.getInt("total");
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return key;
  }

  public int numPositions(String position) {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select count(*) as total from player " +
                      "join position using (position_id) " +
                      "where abbrevation = \"" + position + "\"";
      ResultSet rs = stmt.executeQuery(sqlGet);
      rs.next();
      key = rs.getInt("total");
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return key;
  }

  public int[] getPosition(String position, int size, int salary) {
    int[] playerArray = new int[size];
    int index = 0;
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select player_id from player " +
                        "join position using (position_id) " +
                        "join season_stats using (player_id) " +
                        "where abbrevation = \"" + position + "\" " +
                        "and salary < " + salary;
      ResultSet rs = stmt.executeQuery(sqlGet);
      while (rs.next()){
        playerArray[index] = rs.getInt("player_id");
        index++;
      }
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return playerArray;
  }

  public int[] championshipPlayers(String position, int[] currentroster, int salary) {
    int[] playerArray = getPosition(position, numPositions(position), salary);
    if (position == "PG") {
      int[] rankedArray = championshipPGs(playerArray, currentroster, salary);
    }
    return null;
  }

  private int[] championshipPGs(int[] PGarray, int[] currentroster, int salary) {
    List avaiablePGs = new ArrayList<Integer>();
    for(int value: PGarray) {
      avaiablePGs.add(value);
    }

    System.out.println("currentroster size: " + currentroster.length);
    List rosterList = new ArrayList<Integer>();
    for(int value: currentroster) {
      rosterList.add(value);
    }
    System.out.println("rosterList size: " + rosterList.size());
    for (int i = 0; i < rosterList.size(); i++) {
      System.out.println(rosterList.get(i));
    }


    avaiablePGs.removeAll(rosterList);
    for(int i = 0; i < rosterList.size(); i++) {
      avaiablePGs.remove(avaiablePGs.size() - 1);
    }

    System.out.println("avaiablePGS size: " + avaiablePGs.size());
    for (int i = 0; i < avaiablePGs.size(); i++) {
      System.out.println(avaiablePGs.get(i));
    }
    /*
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      // Build the SQL
      StringBuilder sqlGet = new StringBuilder("SELECT player_id FROM season_stats " +
                                            "WHERE position_id = 1 and salary < " + salary +
                                            " AND player_id NOT IN (");
      System.out.println("test1");
      for (int i = 0; i < currentroster.length; i++) {
        sqlGet.append(currentroster[i]);
        sqlGet.append(",");
      }
      // Delete the last comma
      sqlGet.delete(sqlGet.length()-1, sqlGet.length());
      sqlGet.append(")");
      System.out.println(sqlGet.toString());

      ResultSet rs = stmt.executeQuery(sqlGet.toString());
      int[] championPGsArray = new int[PGarray.length];
      int index = 0;
      while (rs.next()){
        championPGsArray[index] = rs.getInt("player_id");
        index++;
      }
      System.out.println("size: " + index);
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }

    for (int i = 0; i < currentroster.length; i++) {

    }
    */
    return null;
  }

}
