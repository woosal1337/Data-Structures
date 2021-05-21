package com.company;

public class Player {
    // Creating the general user info here with according information
    // such as the name, points they have, and finally the number of
    // games they have played so far.

    String player_name;
    double points;
    int number_of_played_games;

    Player(String name) {
        this.player_name = name;
        this.points = 0;
        this.number_of_played_games = 0;
    }
}
