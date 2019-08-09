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

  /*
  public int[] getPositionPlayers(String position, int size, int salary) {
    return dbu.getPosition(position, size, salary);
  }
  */


  /*
  public int[] getChampionshipPGS(int[] currentroster, int salary) {
    return dbu.championshipPlayers("PG", currentroster, salary);
  }
  */

  /*
  public int getNumPositions(String position){
    return dbu.numPositions(position);
  }
  */

  public PlayoffStats[] addPlayer(SeasonStats[] currentRoster, int num, int playerID) {
    return dbu.addPlayer(currentRoster, num, playerID);
  }

  public SeasonStats[] getTankPlayers(String position, int salary) {
    return dbu.tankPlayers(position, salary);
  }

  public SeasonStats[] getFuturePlayers(String position, int salary) {
    return  dbu.futurePlayers(position, salary);
  }

}
