import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NBATeamBuilder {

  //TESTEST

  private static NBADatabaseMySQL api = new NBADatabaseMySQL();

  public static void main(String args[]) {

    /*
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter server username: ");
    String username = scan.next();
    System.out.println("Enter server password: ");
    String password = scan.next();

    api.authenticate(username, password); // DON'T HARDCODE PASSWORDS!
*/

    /*
    api.authenticate("docpat_user", "docpat_p@ssword");

    System.out.println("Adding playstyles");
    int sid1 = api.getOrInsertPlaystyle("DEFENSE");
    int sid2 = api.getOrInsertPlaystyle("PACE AND SPACE");
    int sid3 = api.getOrInsertPlaystyle("BALANCED");
    int sid4 = api.getOrInsertPlaystyle("TEST ADD 1");       // This one doesn't yet exist
    int sid5 = api.getOrInsertPlaystyle("BLAHBLAHBLAH");     // repeat request
    System.out.println("Specialty IDs: "+sid1+" "+sid2+" "+sid3+" "+sid4+" "+sid5);
    api.closeConnection();
    */

    Scanner scan = new Scanner(System.in);
    System.out.println("What position are you looking for?");
    String target_pos = scan.next();
    api.authenticate("docpat_user", "docpat_p@ssword");
    int size = api.getNumPositions(target_pos);
    System.out.println("Number of players: " + size);
    int[] players = api.getPositionPlayers(target_pos, size);
    for (int i = 0; i < size; i++) {
      System.out.println(players[i]);
    }
    api.closeConnection();
  }

}
