import java.sql.ResultSet;
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

    /*
    IDEA: make Player class/object that stores player_id and other info that's frequently accessed
      ex. position_id, salary
    User enters a position
    If there is already a player who plays that position on the team, they are looking for a:
      BENCH player
    If not, they are looking for a STARTER
    Edge case:
      they have a bench player (ex. PG), and they search for PG,
      which means they actually want a starter
        Idea: differentiate by minutes played (25)
    If user enters team w/ 3 players, and they have $30 mil salary cap space left,
    do we ask user how much they wanna spend?
    Pictures: save pics for top 40-50 players; use empty profile for rest
    Injuries: state injury when player / injury is chosen (red cross)
      have option to choose another player / pass
    Let them pass
    Filter by players w/o severe injuries
    Limit # players by position (limit to 2)
    Algorithms:
      GOAL: Championship
        Considerations:
          Injury data?
          Salary
          Games played and mpg
          Playoff experience
          Playoff stats > season stats
          Based on position (season/playoff):
            PG: ast, steals, to, 3p%
            SG: 3p%
            SF: above average all stats
            PF: reb, blocks
            C: reb, blocks, ft% (everyone)
          Advance stats (NetRtg, PIE)
          Based on position (advanced stats):
            PG: ast%, ast/to, ast ratio, to ratio
            SG/SF
            PF/C: OREB%, DREB%, REB%
              idea: differenciate b/w PF/C w/ weighting diff rebounding percetage
    Coach: recommend at very end
     */


    Scanner scan = new Scanner(System.in);
    System.out.println("What is the goal for your team?");
    String goal = scan.next();
    System.out.println("What position are you looking for?");
    String target_pos = scan.next();
    api.authenticate("docpat_user", "docpat_p@ssword");

    /*
    int size = api.getNumPositions(target_pos);
    System.out.println("Number of players: " + size);
    int[] players = api.getPositionPlayers(target_pos, size);
    for (int i = 0; i < size; i++) {
      System.out.println(players[i]);
    }
    */

    api.closeConnection();

  }

}
