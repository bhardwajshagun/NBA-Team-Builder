import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NBATeamBuilder {

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
    api.authenticate("docpat_user", "docpat_p@ssword");

    System.out.println("Adding playstyles");
    int sid1 = api.getOrInsertPlaystyle("DEFENSE");
    int sid2 = api.getOrInsertPlaystyle("PACE AND SPACE");
    int sid3 = api.getOrInsertPlaystyle("BALANCED");
    int sid4 = api.getOrInsertPlaystyle("TEST ADD 1");       // This one doesn't yet exist
    int sid5 = api.getOrInsertPlaystyle("BLAHBLAHBLAH");     // repeat request
    System.out.println("Specialty IDs: "+sid1+" "+sid2+" "+sid3+" "+sid4+" "+sid5);
    api.closeConnection();

  }

}
