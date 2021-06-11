import java.util.ArrayList;

public class Player {
    public String name;
    private int wins;
    private int losses;
    private ArrayList<Character> log = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void losing() {
        log.add('-');
        losses++;
    }

    public void winning() {
        log.add('+');
        wins++;
    }

    public void printLog() {
        System.out.println("Player Name: " +
                name + "\nTotal Played: " +
                (wins + losses) +
                "\nNumber of Wins: " + wins +
                +losses + "\nLog: " +
                log.toString());
    }
}
