/**
 * This abstract class represents a single player's stats that contains all the standard statistics
 * found in either the regular season or in the playoffs. The methods performed in this class are
 * retrieving any of the stats as a int or float data type. This class is under the Stat interface
 * and is extended to the season and playoff subclasses. The data is drawn from the NBA database in
 * mySQL.
 */

public abstract class PlayoffStats extends Player {

  /**
   * Number of games played as an int data type.
   */
  protected int games;

  /**
   * Number of minutes played as an int data type.
   */
  protected int minutes;

  /**
   * Number of points scored as an int data type.
   */
  protected float points;

  /**
   * Field goals made as an int data type.
   */
  protected float FGM;

  /**
   * Field goals attempted as an int data type.
   */
  protected float FGA;

  /**
   * Field goal percentage as a float data type.
   */
  protected float FG_PER;

  /**
   * Three-point field goals made as an int data type.
   */
  protected float THREE_PM;

  /**
   * Three-point field goals attempted as an int data type.
   */
  protected float THREE_PA;

  /**
   * Three-point field goal percentage as a float data type.
   */
  protected float THREE_P_PER;

  /**
   * Free throws made as an int data type.
   */
  protected float FTM;

  /**
   * Free throws attempted as an int data type.
   */
  protected float FTA;

  /**
   * Free throw percentage as a float data type.
   */
  protected float FT_PER;

  /**
   * Number of offensive rebounds as an int data type.
   */
  protected float OREB;

  /**
   * Number of defensive rebounds as an int data type.
   */
  protected float DREB;

  /**
   * Number of total rebounds as an int data type.
   */
  protected float REB;

  /**
   * Number of assists as an int data type.
   */
  protected float AST;

  /**
   * Number of turnovers as an int data type.
   */
  protected float TOV;

  /**
   * Number of steals as an int data type.
   */
  protected float STL;

  /**
   * Number of blocks as an int data type.
   */
  protected float BLK;

  /**
   * Number of personal fouls as an int data type.
   */
  protected float PF;

  /**
   * Number of fantasy points as an int data type.
   */
  protected float FP;

  /**
   * Number of double doubles as an int data type.
   */
  protected int DD2;

  /**
   * Number of triple doubles as an int data type.
   */
  protected int TD3;

  public PlayoffStats(int playerID, String name, int age, int experience, int position) {
    super(playerID, name, age, experience, position);
  }

  /**
   * Constructs the StandardStats object that takes in and initializes with these attributes as int
   * and float data types that are then invoked to its subclasses's constructors.
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
   */
  public void setPlayoffStats(int games, int minutes, float points, float FGM, float FGA, float FG_PER,
                      float THREE_PM, float THREE_PA, float THREE_P_PER, float FTM, float FTA,
                      float FT_PER, float OREB, float DREB, float REB, float AST, float TOV, float STL,
                      float BLK, float PF, float FP, int DD2, int TD3) {
    this.games = games;
    this.minutes = minutes;
    this.points = points;
    this.FGM = FGM;
    this.FGA = FGA;
    this.FG_PER = FG_PER;
    this.THREE_PM = THREE_PM;
    this.THREE_PA = THREE_PA;
    this.THREE_P_PER = THREE_P_PER;
    this.FTM = FTM;
    this.FTA = FTA;
    this.FT_PER = FT_PER;
    this.OREB = OREB;
    this.DREB = DREB;
    this.REB = REB;
    this.AST = AST;
    this.TOV = TOV;
    this.STL = STL;
    this.BLK = BLK;
    this.PF = PF;
    this.FP = FP;
    this.DD2 = DD2;
    this.TD3 = TD3;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of games
   * played.
   *
   * @return the number of games played as an int data type.
   */
  public int getGames() {
    return games;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of minutes
   * played.
   *
   * @return the number of minutes played as an int data type.
   */
  public int getMinutes() {
    return minutes;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of points
   * scored.
   *
   * @return the number of points scored as an int data type.
   */
  public float getPoints() {
    return points;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of field
   * goals made.
   *
   * @return the number of field goals made as an int data type.
   */
  public float getFGM() {
    return FGM;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of field
   * goals attempted.
   *
   * @return the number of field goals attempted as an int data type.
   */
  public float getFGA() {
    return FGA;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the field goal
   * percentage.
   *
   * @return field goal percentage as an float data type.
   */
  public float getFG_PER() {
    return FG_PER;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * three-point field goals made.
   *
   * @return the number of three-point field goals made as an int data type.
   */
  public float getTHREE_PM() {
    return THREE_PM;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * three-point field goals attempted.
   *
   * @return the number of three-point field goals attempted as an int data type.
   */
  public float getTHREE_PA() {
    return THREE_PA;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the three-point field
   * goal percentage.
   *
   * @return three-point field goal percentage as an float data type.
   */
  public float getTHREE_P_PER() {
    return THREE_P_PER;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of free
   * throws made.
   *
   * @return the number of free throws made as an int data type.
   */
  public float getFTM() {
    return FTM;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of free
   * throws attempted.
   *
   * @return the number of free throws attempted as an int data type.
   */
  public float getFTA() {
    return FTA;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the free throw
   * percentage.
   *
   * @return free throw percentage as an float data type.
   */
  public float getFT_PER() {
    return FT_PER;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * offensive rebounds.
   *
   * @return the number of offensive rebounds as an int data type.
   */
  public float getOREB() {
    return OREB;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * defensive rebounds.
   *
   * @return the number of defensive rebounds as an int data type.
   */
  public float getDREB() {
    return DREB;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of total
   * rebounds.
   *
   * @return the number of total rebounds as an int data type.
   */
  public float getREB() {
    return REB;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * assists.
   *
   * @return the number of assists as an int data type.
   */
  public float getAST() {
    return AST;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * turnovers.
   *
   * @return the number of turnovers as an int data type.
   */
  public float getTOV() {
    return TOV;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * steals.
   *
   * @return the number of steals as an int data type.
   */
  public float getSTL() {
    return STL;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * blocks.
   *
   * @return the number of blocks as an int data type.
   */
  public float getBLK() {
    return BLK;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * personal fouls.
   *
   * @return the number of personal fouls as an int data type.
   */
  public float getPF() {
    return PF;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of fantasy
   * points.
   *
   * @return the number of fantasy points as an int data type.
   */
  public float getFP() {
    return FP;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of double
   * doubles.
   *
   * @return the number of double doubles as an int data type.
   */
  public int getDD2() {
    return DD2;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of triple
   * doubles.
   *
   * @return the number of triple doubles as an int data type.
   */
  public int getTD3() {
    return TD3;
  }
}