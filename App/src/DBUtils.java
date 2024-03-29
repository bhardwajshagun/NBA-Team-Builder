import java.sql.*;
import java.util.Arrays;

public class DBUtils {

  private String url;
  private String user;
  private String password;
  private Connection con;

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

  public String[] getAllPlayers() {
    int size = getCount("player");
    int index = 0;
    String[] players = new String[size];
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "SELECT player_name FROM player";
      ResultSet rs = stmt.executeQuery(sqlGet);
      while (rs.next()){
        players[index] = rs.getString("player_name");
        index++;
      }
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return players;
  }

  public PlayoffStats[] addPlayer(SeasonStats[] currentRoster, int num, int playerID) {
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "SELECT * FROM Season_Stats " +
                      "JOIN player using (player_id) " +
                      "WHERE player_id = " + playerID;
      ResultSet rs = stmt.executeQuery(sqlGet);
      if (rs.next()) {
        currentRoster[num] = new SeasonStats(
                rs.getInt("player_id"),
                rs.getString("player_name"),
                rs.getInt("age"),
                rs.getInt("experience"),
                rs.getInt("position_id"));
        currentRoster[num].setSeasonStats(
                rs.getInt("games_played"),
                rs.getInt("minutes"),
                rs.getFloat("points"),
                rs.getFloat("FGM"),
                rs.getFloat("FGA"),
                rs.getFloat("FG_PER"),
                rs.getFloat("THREE_PM"),
                rs.getFloat("THREE_PA"),
                rs.getFloat("THREE_P_PER"),
                rs.getFloat("FTM"),
                rs.getFloat("FTA"),
                rs.getFloat("FT_PER"),
                rs.getFloat("OREB"),
                rs.getFloat("DREB"),
                rs.getFloat("REB"),
                rs.getFloat("AST"),
                rs.getFloat("TOV"),
                rs.getFloat("STL"),
                rs.getFloat("BLK"),
                rs.getFloat("PF"),
                rs.getFloat("FP"),
                rs.getInt("DD2"),
                rs.getInt("TD3"),
                rs.getInt("SALARY"));
      } else {
      }
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return currentRoster;
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

  public int numPositions(String position, int salary) {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select count(*) as total from player " +
                      "join season_stats using (player_id)" +
                      "join position using (position_id) " +
                      "where abbrevation = \"" + position + "\"" +
                      "and salary < "  + salary;
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

  public SeasonStats[] getPosition(String position, int size, int salary) {
    SeasonStats[] playerArray = new SeasonStats[size];
    int index = 0;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select * from player " +
                        "join position using (position_id) " +
                        "join season_stats using (player_id) " +
                        "where abbrevation = \"" + position + "\" " +
                        "and salary < " + salary;
      ResultSet rs = stmt.executeQuery(sqlGet);
      while (rs.next()){
        playerArray[index] = new SeasonStats(
                        rs.getInt("player_id"),
                        rs.getString("player_name"),
                        rs.getInt("age"),
                        rs.getInt("experience"),
                        rs.getInt("position_id"));
        playerArray[index].setSeasonStats(
                rs.getInt("games_played"),
                rs.getInt("minutes"),
                rs.getFloat("points"),
                rs.getFloat("FGM"),
                rs.getFloat("FGA"),
                rs.getFloat("FG_PER"),
                rs.getFloat("THREE_PM"),
                rs.getFloat("THREE_PA"),
                rs.getFloat("THREE_P_PER"),
                rs.getFloat("FTM"),
                rs.getFloat("FTA"),
                rs.getFloat("FT_PER"),
                rs.getFloat("OREB"),
                rs.getFloat("DREB"),
                rs.getFloat("REB"),
                rs.getFloat("AST"),
                rs.getFloat("TOV"),
                rs.getFloat("STL"),
                rs.getFloat("BLK"),
                rs.getFloat("PF"),
                rs.getFloat("FP"),
                rs.getInt("DD2"),
                rs.getInt("TD3"),
                rs.getInt("SALARY"));
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

  public SeasonStats[] futurePlayers(String position, int salary) {
    SeasonStats[] players;
    if (position.equals("PG")) {
      players = futurePGs(salary);
    } else if (position.equals("SG")) {
      players = futureSGs(salary);
    } else if (position.equals("SF")) {
      players =  futureSFs(salary);
    } else if (position.equals("PF")) {
      players =  futurePFs(salary);
    }
    else {
      players = futureCs(salary);
    }
    for (int i = 0; i < players.length; i++) {
      if (players[i].getGames() < 40 || players[i].getMinutes() < 15) {
        players[i].value -= 1000000;
      }
    }
    Arrays.sort(players, new PlayerComparator());
    return players;
  }

  public SeasonStats[] futurePGs(int salary) {
    SeasonStats[] pgs = getPosition("PG", numPositions("PG", salary), salary);
    for(int i = 0; i < pgs.length; i++) {
      float value = 0;
      value += -(pgs[i].getSalary() / 2000000.0);
      value += -pgs[i].getAge();
      value += pgs[i].getAST();
      value += -pgs[i].getTOV();
      value += pgs[i].getSTL();
      value += pgs[i].getGames();
      value += pgs[i].getMinutes();
      pgs[i].setValue(value);
    }
    return pgs;
  }

  public SeasonStats[] futureSGs(int salary) {
    SeasonStats[] sgs = getPosition("SG", numPositions("SG", salary), salary);
    for(int i = 0; i < sgs.length; i++) {
      float value = 0;
      value += -(sgs[i].getSalary() / 2000000.0);
      value += -sgs[i].getAge();
      value += sgs[i].getFG_PER();
      value += sgs[i].getTHREE_P_PER();
      value += -sgs[i].getPoints();
      value += sgs[i].getGames();
      value += sgs[i].getMinutes();
      sgs[i].setValue(value);
    }
    return sgs;
  }

  public SeasonStats[] futureSFs(int salary) {
    SeasonStats[] sfs = getPosition("SF", numPositions("SF", salary), salary);
    for(int i = 0; i < sfs.length; i++) {
      float value = 0;
      value += -(sfs[i].getSalary() / 2000000.0);
      value += -sfs[i].getAge();
      value += sfs[i].getTD3();
      value += sfs[i].getPoints();
      value += sfs[i].getREB();
      value += sfs[i].getAST();
      value += sfs[i].getGames();
      value += sfs[i].getMinutes();
      sfs[i].setValue(value);
    }
    return sfs;
  }

  public SeasonStats[] futurePFs(int salary) {
    SeasonStats[] pfs = getPosition("PF", numPositions("PF", salary), salary);
    for(int i = 0; i < pfs.length; i++) {
      float value = 0;
      value += -(pfs[i].getSalary() / 2000000.0);
      value += -pfs[i].getAge();
      value += pfs[i].getREB();
      value += pfs[i].getTHREE_P_PER();
      value += pfs[i].getGames();
      value += pfs[i].getMinutes();
      pfs[i].setValue(value);
    }
    return pfs;
  }

  public SeasonStats[] futureCs(int salary) {
    SeasonStats[] cs = getPosition("C", numPositions("C", salary), salary);
    for(int i = 0; i < cs.length; i++) {
      float value = 0;
      value += -(cs[i].getSalary() / 2000000.0);
      value += -cs[i].getAge();
      value += cs[i].getDD2();
      value += cs[i].getREB();
      value += cs[i].getBLK();
      value += cs[i].getGames();
      value += cs[i].getMinutes();
      cs[i].setValue(value);
    }
    return cs;
  }

  public SeasonStats[] tankPlayers(String position, int salary) {
    SeasonStats[] players;
    if (position.equals("PG")) {
     players = getPosition("PG", numPositions("PG", salary), salary);
    } else if (position.equals("SG")) {
      players =  getPosition("SG", numPositions("SG", salary), salary);
    } else if (position.equals("SF")) {
      players =  getPosition("SF", numPositions("SF", salary), salary);
    } else if (position.equals("PF")) {
      players =  getPosition("PF", numPositions("PF", salary), salary);
    }
    else {
      players = getPosition("C", numPositions("C", salary), salary);
    }
    for (int i = 0; i < players.length; i++) {
      float value = 0;
      value += -(players[i].getSalary() / 1000000.0);
      value += -(players[i].getAge());
      value += -(players[i].getExperience() * 10);
      players[i].setValue(value);
    }
    Arrays.sort(players, new PlayerComparator());
    return players;
  }

  public int numChampionshipPositions(String position, int salary) {
    int key = -1;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select count(*) as total from player " +
              "join position using (position_id) " +
              "join season_stats using (player_id) " +
              "join playoff_stats using (player_id) " +
              "join advance_stats using (player_id) " +
              "where abbrevation = \"" + position + "\" " +
              "and salary < " + salary;
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

  public ChampionshipStats[] getChampionshipPosition(String position, int size, int salary) {
    ChampionshipStats[] playerArray = new ChampionshipStats[size];
    int index = 0;
    try {
      Connection con = getConnection();
      Statement stmt = con.createStatement();
      String sqlGet = "select * from player " +
              "join position using (position_id) " +
              "join season_stats using (player_id) " +
              "join playoff_stats using (player_id) " +
              "join advance_stats using (player_id) " +
              "where abbrevation = \"" + position + "\" " +
              "and salary < " + salary;
      ResultSet rs = stmt.executeQuery(sqlGet);
      while (rs.next()){
        playerArray[index] = new ChampionshipStats(
                rs.getInt("player_id"),
                rs.getString("player_name"),
                rs.getInt("age"),
                rs.getInt("experience"),
                rs.getInt("position_id"));
        playerArray[index].setSeasonStats(
                rs.getInt("playoff_stats.games_played"),
                rs.getInt("playoff_stats.minutes"),
                rs.getFloat("playoff_stats.points"),
                rs.getFloat("playoff_stats.FGM"),
                rs.getFloat("playoff_stats.FGA"),
                rs.getFloat("playoff_stats.FG_PER"),
                rs.getFloat("playoff_stats.THREE_PM"),
                rs.getFloat("playoff_stats.THREE_PA"),
                rs.getFloat("playoff_stats.THREE_P_PER"),
                rs.getFloat("playoff_stats.FTM"),
                rs.getFloat("playoff_stats.FTA"),
                rs.getFloat("playoff_stats.FT_PER"),
                rs.getFloat("playoff_stats.OREB"),
                rs.getFloat("playoff_stats.DREB"),
                rs.getFloat("playoff_stats.REB"),
                rs.getFloat("playoff_stats.AST"),
                rs.getFloat("playoff_stats.TOV"),
                rs.getFloat("playoff_stats.STL"),
                rs.getFloat("playoff_stats.BLK"),
                rs.getFloat("playoff_stats.PF"),
                rs.getFloat("playoff_stats.FP"),
                rs.getInt("playoff_stats.DD2"),
                rs.getInt("playoff_stats.TD3"),
                rs.getInt("SALARY"));
        playerArray[index].setAdvancedStats(
                rs.getFloat("OFFRTG"),
                rs.getFloat("DEFRTG"),
                rs.getFloat("NETRTG"),
                rs.getFloat("AST_PER"),
                rs.getFloat("OREB_PER"),
                rs.getFloat("DREB_PER"),
                rs.getFloat("REB_PER"),
                rs.getFloat("EFG_PER"),
                rs.getFloat("TS_PER"),
                rs.getFloat("USG_PER"),
                rs.getFloat("PACE"),
                rs.getFloat("PIE"));
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

  public ChampionshipStats[] championshipPlayers(String position, int salary) {
    ChampionshipStats[] players;
    if (position.equals("PG")) {
      players = championshipPGs(salary);
    } else if (position.equals("SG")) {
      players = championshipSGs(salary);
    } else if (position.equals("SF")) {
      players =  championshipSFs(salary);
    } else if (position.equals("PF")) {
      players =  championshipPFs(salary);
    }
    else {
      players = championshipCs(salary);
    }
    Arrays.sort(players, new PlayerComparator());
    return players;
  }

  public ChampionshipStats[] championshipPGs(int salary) {
    ChampionshipStats[] pgs = getChampionshipPosition("PG", numChampionshipPositions("PG", salary), salary);
    for (int i = 0; i < pgs.length; i++) {
      float value = 0;
      value += pgs[i].getAST();
      value += pgs[i].getAST_PER();
      value -= pgs[i].getTOV();
      value += pgs[i].getSTL();
      value += pgs[i].getPIE();
      value += pgs[i].getGames();
      value += pgs[i].getMinutes();
      pgs[i].setValue(value);
    }
    return pgs;
  }

  public ChampionshipStats[] championshipSGs(int salary) {
    ChampionshipStats[] sgs = getChampionshipPosition("SG", numChampionshipPositions("SG", salary), salary);
    for (int i = 0; i < sgs.length; i++) {
      float value = 0;
      value += sgs[i].getPoints();
      value += sgs[i].getFG_PER();
      value += sgs[i].getTHREE_P_PER();
      value += sgs[i].getTS_PER();
      value += sgs[i].getPIE();
      value += sgs[i].getGames();
      value += sgs[i].getMinutes();
      sgs[i].setValue(value);
    }
    return sgs;
  }

  public ChampionshipStats[] championshipSFs(int salary) {
    ChampionshipStats[] sfs = getChampionshipPosition("SF", numChampionshipPositions("SF", salary), salary);
    for (int i = 0; i < sfs.length; i++) {
      float value = 0;
      value += sfs[i].getTD3();
      value += sfs[i].getPoints();
      value += sfs[i].getREB();
      value += sfs[i].getAST();
      value += sfs[i].getNETRTG();
      value += sfs[i].getPIE();
      value += sfs[i].getGames();
      value += sfs[i].getMinutes();
      sfs[i].setValue(value);
    }
    return sfs;
  }

  public ChampionshipStats[] championshipPFs(int salary) {
    ChampionshipStats[] pfs = getChampionshipPosition("PF", numChampionshipPositions("PF", salary), salary);
    for (int i = 0; i < pfs.length; i++) {
      float value = 0;
      value += pfs[i].getREB();
      value += pfs[i].getTHREE_P_PER();
      value += pfs[i].getPIE();
      value += pfs[i].getGames();
      value += pfs[i].getMinutes();
      pfs[i].setValue(value);
    }
    return pfs;
  }

  public ChampionshipStats[] championshipCs(int salary) {
    ChampionshipStats[] cs = getChampionshipPosition("C", numChampionshipPositions("C", salary), salary);
    for (int i = 0; i < cs.length; i++) {
      float value = 0;
      value += cs[i].getDD2();
      value += cs[i].getREB();
      value += cs[i].getREB_PER();
      value += cs[i].getBLK();
      value += cs[i].getDEFRTG();
      value += cs[i].getGames();
      value += cs[i].getMinutes();
      cs[i].setValue(value);
    }
    return cs;
  }

}
