public class NBADatabaseMySQL {

  DBUtils dbu;

  public void authenticate(String user, String password) {
    dbu = new DBUtils("jdbc:mysql://localhost:3306/nba?serverTimezone=EST5EDT", user, password);
  }

  /**
   * Close the connection when application finishes
   */
  public void closeConnection() { dbu.closeConnection(); }

  public SeasonStats[] getTankPlayers(String position, int salary) {
    return dbu.tankPlayers(position, salary);
  }

  public SeasonStats[] getFuturePlayers(String position, int salary) {
    return dbu.futurePlayers(position, salary);
  }

  public ChampionshipStats[] getChampionshipPlayers(String position, int salary) {
    return dbu.championshipPlayers(position, salary);
  }

  public String[] getAllPlayers(){
    return dbu.getAllPlayers();
  }

}
