import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class ChessWorldCup {
    private Player[] allPlayers;
    private ArrayList<Player> leftPlayers = new ArrayList<>();
    Random random = new Random();

    public ChessWorldCup(Player[] AllPlayers) {

        this.allPlayers = AllPlayers;
        leftPlayers.addAll(Arrays.asList(AllPlayers));

    }

    public void matching(Player player1, Player player2) {

        if (random.nextInt(2) != 1) {
            player1.winning();
            player2.losing();
            leftPlayers.remove(player1);
            leftPlayers.add(player1);
            leftPlayers.remove(player2);
        }

        else {
            player2.winning();
            player1.losing();
            leftPlayers.remove(player2);
            leftPlayers.add(player2);
            leftPlayers.remove(player1);
        }


        if (leftPlayers.size() == 1) {
            System.out.println(leftPlayers.get(0).name + " wins the final ");
        }

        else if (leftPlayers.size() <= 2) {
            System.out.println(leftPlayers.get(0).name + " wins the semi final");
        }

        else if (leftPlayers.size() <= 4) {
            System.out.println(leftPlayers.get(0).name + " wins the quarter final");
        }


    }

    public void passOneTour() {

        for (int i = 0; i < leftPlayers.size() - 1; i += 2) {
            matching(leftPlayers.get(i), leftPlayers.get(i + 1));
        }

        if (leftPlayers.size() % 2 == 0) {
            System.out.println(leftPlayers.get(leftPlayers.size() - 1).name + " passed instantly.");
        }
    }

    public void results() {

        System.out.println("Full Match Log:");
        for (Player player : allPlayers)
            player.printLog();
    }
}
