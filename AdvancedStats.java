
/**
 * This abstract class represents a single player's stats that contains all advanced metrics from
 * the regular season. The methods performed in this class are retrieving any of the stats as a int
 * or float data type. This class is under the Stat interface. The data is drawn from the NBA
 * database in mySQL.
 */
public class AdvancedStats {

  /**
   * Number of team points scored per 100 possessions while the player is on court as an int data
   * type.
   */
  protected int offRtg;

  /**
   * Number of points per 100 possessions that the team allows while the player is on the court as
   * an int data type.
   */
  protected int defRtg;

  /**
   * Team's point differential per 100 possessions while the player is on court as an int data
   * type.
   */
  protected int netRtg;

  /**
   * Percentage of teammate field goals made the player assisted on as a float data type.
   */
  protected float ast_per;

  /**
   * Percentage of available offensive rebounds a player obtains while on court as a float data
   * type.
   */
  protected float oreb_per;

  /**
   * Percentage of available defensive rebounds a player obtains while on court as a float data
   * type.
   */
  protected float dreb_per;

  /**
   * Percentage of available rebounds a player obtains while on court as an float data type.
   */
  protected float reb_per;

  /**
   * Effective Field Goal Percentage as an float data type.
   */
  protected float efg_per;

  /**
   * True shooting percentage as a float data type.
   */
  protected float ts_per;

  /**
   * Usage percentage as a float data type.
   */
  protected float usg_per;

  /**
   * Number of possessions per 48 minutes for the player as an int data type.
   */
  protected int pace;

  /**
   * Player Impact Estimate as a float data type.
   */
  protected float pie;

  /**
   * Constructs the AdvancedStats object that takes in and initializes with these attributes as int
   * and float data types.
   *
   * @param offRtg   Offensive Rating
   * @param defRtg   Defensive Rating
   * @param netRtg   Net Rating
   * @param ast_per  Assist Percentage
   * @param oreb_per Offensive Rebounding Percentage
   * @param dreb_per Defensive Rebounding Percentage
   * @param reb_per  Rebounding Percentage
   * @param efg_per  Effective Field Goal Percentage
   * @param ts_per   True Shooting Percentage
   * @param usg_per  Usage Percentage
   * @param pace     Number of possessions per 48 minutes for the player.
   * @param pie      Player Impact Estimate
   */
  public AdvancedStats(int offRtg, int defRtg, int netRtg, float ast_per, float oreb_per,
                       float dreb_per, float reb_per, float efg_per, float ts_per, float usg_per,
                       int pace, float pie) {
    this.offRtg = offRtg;
    this.defRtg = defRtg;
    this.netRtg = netRtg;
    this.ast_per = ast_per;
    this.oreb_per = oreb_per;
    this.dreb_per = dreb_per;
    this.reb_per = reb_per;
    this.efg_per = efg_per;
    this.ts_per = ts_per;
    this.usg_per = usg_per;
    this.pace = pace;
    this.pie = pie;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Offensive Rating
   * of said player.
   *
   * @return the Offensive Rating as an int data type.
   */
  public int getOffRtg() {
    return offRtg;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Defensive Rating
   * of said player.
   *
   * @return the Defensive Rating as an int data type.
   */
  public int getDefRtg() {
    return defRtg;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Net Rating of
   * said player.
   *
   * @return the Net Rating as an int data type.
   */
  public int getNetRtg() {
    return netRtg;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Assist Percentage
   * of said player.
   *
   * @return the Assist Percentage as a float data type.
   */
  public float getAst_per() {
    return ast_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Offensive
   * Rebounding Percentage of said player.
   *
   * @return the Offensive Rebounding Percentage as a float data type.
   */
  public float getOreb_per() {
    return oreb_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Defensive
   * Rebounding Percentage of said player.
   *
   * @return the Defensive Rebounding Percentage as a float data type.
   */
  public float getDreb_per() {
    return dreb_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Rebounding
   * Percentage of said player.
   *
   * @return the Rebounding Percentage as a float data type.
   */
  public float getReb_per() {
    return reb_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Effective Field
   * Goal Percentage of said player.
   *
   * @return the Effective Field Goal Percentage as a float data type.
   */
  public float getEfg_per() {
    return efg_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the True Shooting
   * Percentage of said player.
   *
   * @return the True Shooting Percentage as a float data type.
   */
  public float getTs_per() {
    return ts_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Usage Percentage
   * of said player.
   *
   * @return the Usage Percentage as a float data type.
   */
  public float getUsg_per() {
    return usg_per;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the number of
   * possessions per 48 minutes for the said player.
   *
   * @return the PACE as an int data type.
   */
  public int getPace() {
    return pace;
  }

  /**
   * Public getter method that takes in no arguments as parameters and returns the Player Impact
   * Estimate of said player.
   *
   * @return the Player Impact Estimate as an int data type.
   */
  public float getPie() {
    return pie;
  }
}
