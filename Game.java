
import java.util.HashMap;
public class Game {
  // Private instance variables to store the facts and score
  private HashMap<String, Integer> players; // Constructor, to initialize the instance variable
  public Game () {
    LeaderBoard state = LeaderBoard.restore();
    if(state!=null) {
    players = state.scores;
    }
    else{
    players = new HashMap<String, Integer>();
    }
    int roundFlag = 0;
    while(roundFlag == 0){
    Round g = new Round();
    String name = Utils.inputStr ("What's your name? ");
    players.put(name, g.run());
    roundFlag = Utils.inputNum("Type \"0\" to play again \nType anything else to quit: ");
    //System.out.println("inside");
    }
    //System.out.println("outside");
    state = new LeaderBoard();
    state.scores = players;
    state.save();
    } 
  public void leaderBoard() {
    for(String n: players.keySet()) {
    String key = n.toString();
    String value = players.get(n).toString();
    System.out.println(key + " " + value);
    }
    }
}








        