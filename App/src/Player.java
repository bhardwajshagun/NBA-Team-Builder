public abstract class Player{

  protected int playerID;
  protected String name;
  protected int age;
  protected int experience;
  protected int position;
  protected float value;

  public Player(int playerID, String name, int age, int experience, int position) {
    this.playerID = playerID;
    this.name = name;
    this.age = age;
    this.experience = experience;
    this.position = position;
  }

  public void setValue(float value) {
    this.value = value;
  }

  public int getPlayerID() {
    return playerID;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getExperience() {
    return experience;
  }

  public int getPosition() {
    return position;
  }


  public float getValue() {
    return value;
  }

}
