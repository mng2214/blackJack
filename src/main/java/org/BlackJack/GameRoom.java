package B16MentoringWithArtur.project21;

import java.util.Scanner;

public class GameRoom {


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO CASINO\nPlease enter your name...");
        String playerName = scanner.nextLine();
        Dealer dealer1 = new Dealer();
        Rules rules = new Rules();
        Player player = new Player(playerName);


        String playAgain = "";
        System.out.println("Good evening\nMy name is " + dealer1.dealerName + ". Lets start and GOOD LUCK!\nDealer balance: " + dealer1.dealerBalance);
        do {

            /*
            create 4 classes. GameRoom, Rules, Player, Dealer.
            GameRoom will have our main methods and you gonna call created methods from Rules class.
            player and dealer will have instance vars and constructor. Balance and game for money we
            gonna keep for next time. For now we just gonna build game logic.
             */

            //create a method to start the game. Dealer introduction and balance per player and dealer.
            //Tts going to be return void and be like little info before the game
           // rules.introAndBalance(playerName);

            //create a method to dealt random card to a player and ask him if he wants to get more.
            //if he has over 21 points - he lost, if he get exact 21 points - BLACK JACK he wont, he is gets
            //under 21 points and has decided to stop the method and return amount of points.
            //keep in mind once you dealt the card it has to be removed from the deck
            //HINTS: Collection.shuffle(List) --> shuffles deck
            //HINTS: All cards can be saved List. and Create Card class to keep every card and point there

            int playerPoints = rules.playersHand();

            //dealer dealing 2 cards for him self.  build logic where he needs to check
            //his 2 cards has more points than player1's or not. and if not take 1 more card and if yes stop game.
            //then compare points and determine a winner. if equal its Tie!

           int dealerPoints = rules.dealerHand(playerPoints);

            //after each game ask user if he want to play again. if yes run all logic again

            System.out.println("Do you want to play again?");
            scanner = new Scanner(System.in);
            playAgain = scanner.nextLine();

        } while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y"));
        System.out.println("\nThanks for the game.\nSee you next time");
    }

}
