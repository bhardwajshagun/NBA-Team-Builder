public class SeasonStats extends PlayoffStats {

  /**
   * Salary of the player for that year as an int data type.
   */
  protected int salary;

  public SeasonStats(int playerID, String name, int age, int experience, int position) {
    super(playerID, name, age, experience, position);
  }

  /**
   * Constructs the SeasonStats object that takes in and initializes with these attributes as int
   * and float data types that are invoked by the superclass StandardStats constructor.
   *
   * @param games       number of games played as an int data type
   * @param minutes     number of minutes played as an int data type
   * @param points      number of points scored as an float data type
   * @param FGM         field goals made as an float data type
   * @param FGA         field goals attempted as an float data type
   * @param FG_PER      field goal percentage as a float data type
   * @param THREE_PM    three-point field goals made as an float data type
   * @param THREE_PA    three-point field goals attempted as an float data type
   * @param THREE_P_PER three-point field goal percentage as a float data type
   * @param FTM         free throws made as an float data type.
   * @param FTA         free throws attempted as an float data type
   * @param FT_PER      free throw percentage as a float data type
   * @param OREB        number of offensive rebounds as an float data type
   * @param DREB        number of defensive rebounds as an float data type
   * @param REB         number of total rebounds as an float data type
   * @param AST         number of assists as an float data type
   * @param TOV         number of turnovers as an float data type
   * @param STL         number of steals as an float data type
   * @param BLK         number of blocks as an float data type
   * @param PF          number of personal fouls as an float data type
   * @param FP          number of fantasy points as an float data type
   * @param DD2         number of double doubles as an int data type
   * @param TD3         number of triple doubles as an int data type
   * @param salary      salary of player as an int data type
   */
  public void setSeasonStats(int games, int minutes, float points, float FGM, float FGA, float FG_PER,
                     float THREE_PM, float THREE_PA, float THREE_P_PER, float FTM, float FTA,
                     float FT_PER, float OREB, float DREB, float REB, float AST, float TOV, float STL,
                     float BLK, float PF, float FP, int DD2, int TD3, int salary) {
    super.setPlayoffStats(games, minutes, points, FGM, FGA, FG_PER, THREE_PM, THREE_PA, THREE_P_PER, FTM, FTA,
            FT_PER, OREB, DREB, REB, AST, TOV, STL, BLK, PF, FP, DD2, TD3);
    this.salary = salary;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the salary of said
   * player.
   *
   * @return the salary as an int data type.
   */
  public int getSalary() {
    return salary;
  }

}