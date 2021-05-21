package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ChessTournament {
    private PriorityQueue<Player> player_queue;
    private List<Player> players;
    private boolean is_finished;
    private int players_with_10_matches;


    ChessTournament(List<Player> playerList) {
        this.players = playerList;
        is_finished = false;
        players_with_10_matches = 0;
    }

    public Player removeTopOfPQ() { return player_queue.poll(); }

    public void addPlayerToPQ(Player p) { player_queue.add(p); }

    public void simulateChessTournament() {
        player_queue = new PriorityQueue<Player>(new ComparePlayers());
        player_queue.addAll(players);

        while (player_queue.size() >= 2 && !is_finished) {
            Player p1 = removeTopOfPQ();
            Player p2 = removeTopOfPQ();

            int result = random_value();

            if (result == 0) {
                p1.points = p1.points + 1;
            }
            else if (result == 1) {
                p1.points = p1.points + 0.5;
                p2.points = p2.points + 0.5;
            }
            else {
                p2.points = p2.points + 1;
            }
            p1.number_of_played_games++;
            p2.number_of_played_games++;

            if (p1.number_of_played_games == 10) {
                players_with_10_matches++;
            }
            else {
                addPlayerToPQ(p1);
            }

            if (p2.number_of_played_games == 10) {
                players_with_10_matches++;
            }
            else {
                addPlayerToPQ(p2);
            }

            if (players_with_10_matches >= 4) {
                is_finished = true;
            }
        }
    }


    public List<Player> sortedPlayers() {
        player_queue.clear();
        player_queue.addAll(players);
        List<Player> sortedPlayersList = new ArrayList<>();
        while (!player_queue.isEmpty()) {
            sortedPlayersList.add(removeTopOfPQ());
        }
        return sortedPlayersList;
    }

    private int random_value() {
        Random rand = new Random();
        return rand.nextInt() % 3;
    }
}
