import java.sql.*;

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


  public int insertOneRecord(String insertSQL)
  {
    // System.out.println("INSERT STATEMENT: "+insertSQL);
    int key = -1;
    try {

      // get connection and initialize statement
      Connection con = getConnection();
      Statement stmt = con.createStatement();

      stmt.executeUpdate(insertSQL, Statement.RETURN_GENERATED_KEYS);

      // extract auto-incremented ID
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) key = rs.getInt(1);

      // Cleanup
      rs.close();
      stmt.close();

    } catch (SQLException e) {
      System.err.println("ERROR: Could not insert record: "+insertSQL);
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return key;
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

  public int numPositions(String pos) {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select count(*) as total from player " +
                      "join position using (position_id) " +
                      "where abbrevation = \"" + pos + "\"";
      System.out.println("test");
      ResultSet rs = stmt.executeQuery(sqlGet);
      rs.next();
      key = rs.getInt("total");
      System.out.println("test2");
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return key;
  }

  public int[] getPosition(String position, int size) {
    int[] playerArray = new int[size];
    int index = 0;
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select player_id from player " +
                        "join position using (position_id) " +
                        "where abbrevation = \"" + position + "\"";
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

}
