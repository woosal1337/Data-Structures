package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        // Declaring new players to be assigned to the queue
        // Assigning the players to the queue

        Player p1 = new Player("Player 1");
        players.add(p1);

        Player p2 = new Player("Player 2");
        players.add(p2);

        Player p3 = new Player("Player 3");
        players.add(p3);

        Player p4 = new Player("Player 4");
        players.add(p4);

        Player p5 = new Player("Player 5");
        players.add(p5);

        Player p6 = new Player("Player 6");
        players.add(p6);

        Player p7 = new Player("Player 7");
        players.add(p7);

        Player p8 = new Player("Player 8");
        players.add(p8);

        Player p9 = new Player("Player 9");
        players.add(p9);

        Player p10 = new Player("Player 10");
        players.add(p10);

        ChessTournament tournament = new ChessTournament(players);
        tournament.simulateChessTournament();

        List<Player> sortedPlayers = tournament.sortedPlayers();
        for (int i = 0; i < sortedPlayers.size(); i++) {
            System.out.println("Player Name: " + sortedPlayers.get(i).player_name + " | Total Points: " + sortedPlayers.get(i).points + " | Number Of Games Played: " + sortedPlayers.get(i).number_of_played_games);
        }
    }
}
