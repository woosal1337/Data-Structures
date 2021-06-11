public class TestWorldCup {
    public static void main(String[] args) {

        // 20 Custom Players Creation
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        Player player7 = new Player("Player7");
        Player player8 = new Player("Player8");
        Player player9 = new Player("Player9");
        Player player10 = new Player("Player10");
        Player player11 = new Player("Player11");
        Player player12 = new Player("Player12");
        Player player13 = new Player("Player13");
        Player player14 = new Player("Player14");
        Player player15 = new Player("Player15");
        Player player16 = new Player("Player16");
        Player player17 = new Player("Player17");
        Player player18 = new Player("Player18");
        Player player19 = new Player("Player19");
        Player player20 = new Player("Player20");

        // Full Players List Array
        Player[] players = {
                player1,
                player2,
                player3,
                player4,
                player5,
                player6,
                player7,
                player8,
                player9,
                player10,
                player11,
                player12,
                player13,
                player14,
                player15,
                player16,
                player17,
                player18,
                player19,
                player20
        };

        // Test Tournament
        ChessWorldCup chessWorldCup = new ChessWorldCup(players);
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();
        chessWorldCup.passOneTour();

        // Print the results
        chessWorldCup.results();

    }
}
