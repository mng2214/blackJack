package B16MentoringWithArtur.project21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rules {
    String oneMoreCard = "";
    boolean blackJack = false;
    boolean playerLost = false;





    public Rules() throws InterruptedException {
    }

    public void introAndBalance(String playerName, double balancePlayer) throws InterruptedException {
        System.out.println(playerName + " your balance  is " + balancePlayer + "\n\n");
        Thread.sleep(2000);
    }

    class Card {
        private final String name;
        private final int value;

        public Card(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

    }

    public int playersHand() throws InterruptedException {
        int pointsPLayer = 0;
        Scanner scanner = new Scanner(System.in);
        List<Card> deck = new ArrayList<>();
        deck.add(new Card("A", 11));
        deck.add(new Card("K", 10));
        deck.add(new Card("Q", 10));
        deck.add(new Card("J", 10));
        deck.add(new Card("10", 10));
        deck.add(new Card("9", 9));
        deck.add(new Card("8", 8));
        deck.add(new Card("7", 7));
        deck.add(new Card("6", 6));
        deck.add(new Card("5", 5));
        deck.add(new Card("4", 4));
        deck.add(new Card("3", 3));
        deck.add(new Card("2", 2));

        Collections.shuffle(deck);

        Card card = deck.get(0);
        deck.remove(0);
        pointsPLayer += card.getValue();
        System.out.println("Your card " + card.getName() + " Your points: " + pointsPLayer);
        Thread.sleep(700);

        do {
            if (pointsPLayer > 21) {
                System.out.println("Player Lost!!!");
                playerLost = true;
                break;
            } else if (pointsPLayer == 21) {
                System.out.println("BLACK JACK !!! Player Won!!!");
                blackJack = true;
                break;
            }

            card = deck.get(0);
            deck.remove(0);
            pointsPLayer += card.getValue();
            System.out.println("Your card " + card.getName() + " Your points: " + pointsPLayer);

            if (pointsPLayer == 21) {
                System.out.println("BLACK JACK !!! Player Won!!!");
                blackJack = true;
                break;
            } else if (pointsPLayer > 21) {
                System.out.println("Player Lost!!!");
                break;
            }
            System.out.println("one more card?");
            oneMoreCard = scanner.nextLine();
            Thread.sleep(1000);
        } while (oneMoreCard.equalsIgnoreCase("y") || oneMoreCard.equalsIgnoreCase("yes"));
        System.out.println("Your final points: " + pointsPLayer);

        return pointsPLayer;
    }

    public int dealerHand(int playerP) throws InterruptedException {
        System.out.println("\n-----------\n");
      int  pointsDealer = 0;

        List<Card> deck = new ArrayList<>();
        deck.add(new Card("A", 11));
        deck.add(new Card("K", 10));
        deck.add(new Card("Q", 10));
        deck.add(new Card("J", 10));
        deck.add(new Card("10", 10));
        deck.add(new Card("9", 9));
        deck.add(new Card("8", 8));
        deck.add(new Card("7", 7));
        deck.add(new Card("6", 6));
        deck.add(new Card("5", 5));
        deck.add(new Card("4", 4));
        deck.add(new Card("3", 3));
        deck.add(new Card("2", 2));

        Collections.shuffle(deck);
        if (!blackJack && !playerLost) {
            // deal two cards to the dealer
            for (int i = 0; i < 2; i++) {
                Card card = deck.get(0);
                deck.remove(0);
                pointsDealer += card.getValue();
                System.out.println("Dealer card " + card.getName() + " Dealer points: " + pointsDealer);
                Thread.sleep(1000);
            }
            if (pointsDealer == 21) {
                System.out.println("BLACK JACK dealer WON!");
            }

            // dealer hits until their hand is greater than or equal to the player's hand
            while (pointsDealer < playerP && pointsDealer < 21) {
                Card card = deck.get(0);
                deck.remove(0);
                pointsDealer += card.getValue();
                System.out.println("Dealer card " + card.getName() + " Dealer points: " + pointsDealer);
                Thread.sleep(1000);
            }

            // determine the outcome of the game
            if (pointsDealer > 21) {
                System.out.println("Dealer BUSTED! Player WON!");
            } else if (pointsDealer == playerP) {
                System.out.println("Tie!");
            } else if (pointsDealer > playerP) {
                System.out.println("Dealer WON!");
            } else {
                System.out.println("Player WON!");
            }
        }else {
            System.out.println("dealer won");
        }

        playerLost = false;
        blackJack = false;
        return pointsDealer;
    }
}