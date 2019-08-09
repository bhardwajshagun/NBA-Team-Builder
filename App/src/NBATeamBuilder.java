public class NBATeamBuilder {

  private static NBADatabaseMySQL api = new NBADatabaseMySQL();

  public String[] getAllPlayers() {
    api.authenticate("docpat_user", "docpat_p@ssword");
    String[] players = api.getAllPlayers();
    api.closeConnection();
    return players;
  }

  public String[] getTankPGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getTankPlayers("PG", salary);
    return getNames(players);
  }

  public String[] getTankSGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getTankPlayers("SG", salary);
    return getNames(players);
  }

  public String[] getTankSFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getTankPlayers("SF", salary);
    return getNames(players);
  }

  public String[] getTankPFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getTankPlayers("SF", salary);
    return getNames(players);
  }

  public String[] getTankCs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getTankPlayers("SF", salary);
    return getNames(players);
  }

  public String[] getFuturePGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getFuturePlayers("PG", salary);
    return getNames(players);
  }

  public String[] getFutureSGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getFuturePlayers("SG", salary);
    return getNames(players);
  }

  public String[] getFutureSFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getFuturePlayers("SF", salary);
    return getNames(players);
  }

  public String[] getFuturePFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getFuturePlayers("PF", salary);
    return getNames(players);
  }

  public String[] getFutureCs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] players = api.getFuturePlayers("C", salary);
    return getNames(players);
  }

  public String[] getChampionshipPGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    ChampionshipStats[] players = api.getChampionshipPlayers("PG", salary);
    return getNames(players);
  }

  public String[] getChampionshipSGs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    ChampionshipStats[] players = api.getChampionshipPlayers("SG", salary);
    return getNames(players);
  }

  public String[] getChampionshipSFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    ChampionshipStats[] players = api.getChampionshipPlayers("SF", salary);
    return getNames(players);
  }

  public String[] getChampionshipPFs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    ChampionshipStats[] players = api.getChampionshipPlayers("PF", salary);
    return getNames(players);
  }

  public String[] getChampionshipCs(int salary) {
    api.authenticate("docpat_user", "docpat_p@ssword");
    ChampionshipStats[] players = api.getChampionshipPlayers("C", salary);
    return getNames(players);
  }

  public String[] getNames(Player[] players){
    int size;
    if (players.length < 15) {
      size = players.length;
    } else {
      size = 15;
    }
    String[] playerNames = new String[size];
    for (int i = 0; i < size; i++) {
      playerNames[i] = players[i].getName();
    }
    return playerNames;
  }

}
