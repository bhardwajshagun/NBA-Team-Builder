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

    /*
    int[] currentroster = {2, 3, 8};
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the goal for your team?");
    String goal = scan.next();
    System.out.println("What position are you looking for?");
    String position = scan.next();
    api.authenticate("docpat_user", "docpat_p@ssword");
    int size = api.getNumPositions(position);
    System.out.println("Number of players: " + size);
    int salary = 50000000;
    int[] championshipPGS = api.getChampionshipPGS(currentroster, salary);
    */

    /*
    int[] players = api.getPositionPlayers(position, size, salary);
    for (int i = 0; i < size; i++) {
      System.out.println(players[i]);
    }
    api.closeConnection();
    */

    api.authenticate("docpat_user", "docpat_p@ssword");
    SeasonStats[] currentRoster = new SeasonStats[10];
    int numRoster = 0;
    int salaryCap = 102000000;

    Scanner scan = new Scanner(System.in);
    System.out.println("What is the goal for your team?");
    String goal = scan.next();
    while(true){
      System.out.println("Add player on current roster:");
      int player = scan.nextInt();
      api.addPlayer(currentRoster, numRoster, player);
      numRoster += 1;
      System.out.println("Do you want to add another player? y/n");
      String input = scan.next();
      if(input.equals("n")) {
        break;
      }
    }
    System.out.println("Enter anything to see roster: ");
    String blah = scan.next();
    System.out.println("Num players on roster: " + (numRoster));
    for (int i = 0; i < numRoster; i++) {
      System.out.println("Player " + (i + 1) + ": ");
      System.out.println(currentRoster[i].getName());
      System.out.println(currentRoster[i].getGames());
      System.out.println(currentRoster[i].getMinutes());
      System.out.println(currentRoster[i].getPoints());
      System.out.println(currentRoster[i].getFGM());
      System.out.println(currentRoster[i].getFGA());
      System.out.println(currentRoster[i].getFG_PER());
      System.out.println(currentRoster[i].getTHREE_PM());
      System.out.println(currentRoster[i].getTHREE_PA());
      System.out.println(currentRoster[i].getTHREE_P_PER());
      System.out.println(currentRoster[i].getFTM());
      System.out.println(currentRoster[i].getFTA());
      System.out.println(currentRoster[i].getFT_PER());
      System.out.println(currentRoster[i].getOREB());
      System.out.println(currentRoster[i].getDREB());
      System.out.println(currentRoster[i].getREB());
      System.out.println(currentRoster[i].getAST());
      System.out.println(currentRoster[i].getTOV());
      System.out.println(currentRoster[i].getSTL());
      System.out.println(currentRoster[i].getBLK());
      System.out.println(currentRoster[i].getPF());
      System.out.println(currentRoster[i].getFP());
      System.out.println(currentRoster[i].getDD2());
      System.out.println(currentRoster[i].getTD3());
      System.out.println(currentRoster[i].getSalary());
      System.out.println();
    }

    System.out.println("What position are you looking for?");
    String position = scan.next();
    System.out.println("What is the maximum salary you are willing to pay?");
    int salary = scan.nextInt();
    SeasonStats[] tankSFs = api.getFuturePlayers(position, salary);
    System.out.println("tankSFs size: " + tankSFs.length);
    for(int i = 0; i < tankSFs.length; i++) {
      System.out.println("i: " + i);
      System.out.println(tankSFs[i].getName());
      System.out.println(tankSFs[i].getValue());
    }
    api.closeConnection();
  }

}
