package com.company;

import java.util.Comparator;

public class ComparePlayers implements Comparator<Player> {

    // Comparison part for the final sorting step

    public int compare(Player one, Player two) {
        if (one.points > two.points) { return 1; }
        else if (one.points < two.points) { return -1; }
        else {
            if (one.number_of_played_games > two.number_of_played_games) { return -1; }
            else { return 1; }
        }
    }
}