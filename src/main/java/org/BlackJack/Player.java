package org.BlackJack;

public class Player {
    String playerName;
    double playerBalance;



    public Player(String playerName) {
        this.playerName = playerName;
        this.playerBalance = 100;
        System.out.println("Welcome " + playerName + ". Your balance is: " + playerBalance);
    }

    // payment system will be constructed in next part of the project

}
