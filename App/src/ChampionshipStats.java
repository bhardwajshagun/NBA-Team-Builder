public class ChampionshipStats extends SeasonStats {

  private float OFFRTG;
  private float DEFRTG;
  private float NETRTG;
  private float AST_PER;
  private float OREB_PER;
  private float DREB_PER;
  private float REB_PER;
  private float EFG_PER;
  private float TS_PER;
  private float USG_PER;
  private float PACE;
  private float PIE;

  public ChampionshipStats(int playerID, String name, int age, int experience, int position) {
    super(playerID, name, age, experience, position);
  }

  public void setAdvancedStats(float OFFRTG, float DEFRTG, float NETRTG, float AST_PER,
                               float OREB_PER, float DREB_PER, float REB_PER, float EFG_PER,
                               float TS_PER, float USG_PER, float PACE, float PIE) {
    this.OFFRTG = OFFRTG;
    this.DEFRTG = DEFRTG;
    this.NETRTG = NETRTG;
    this.AST_PER = AST_PER;
    this.OREB_PER = OREB_PER;
    this.DREB_PER = DREB_PER;
    this.REB_PER = REB_PER;
    this.EFG_PER = EFG_PER;
    this.TS_PER = TS_PER;
    this.USG_PER = USG_PER;
    this.PACE = PACE;
    this.PIE = PIE;
  }

  public float getOFFRTG() {
      return OFFRTG;
  }

  public float getDEFRTG() {
    return DEFRTG;
  }

  public float getNETRTG() {
    return NETRTG;
  }

  public float getAST_PER() {
    return AST_PER;
  }

  public float getOREB_PER() {
    return OREB_PER;
  }

  public float getDREB_PER() {
    return DREB_PER;
  }

  public float getREB_PER() {
    return REB_PER;
  }

  public float getEFG_PER() {
    return EFG_PER;
  }

  public float getTS_PER() {
    return TS_PER;
  }

  public float getUSG_PER() {
    return USG_PER;
  }

  public float getPACE() {
    return PACE;
  }

  public float getPIE() {
    return PIE;
  }

}
