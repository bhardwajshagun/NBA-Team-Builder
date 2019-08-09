import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

  @Override
  public int compare(Player player1, Player player2) {
    float change1 = player1.getValue();
    float change2 = player2.getValue();
    if (change1 < change2) return 1;
    if (change1 > change2) return -1;
    return 0;
  }

}
