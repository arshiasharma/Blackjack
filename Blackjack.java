/** This is the class Blackjack */

/** importing the Scanner class for user input */
import java.util.Scanner;

/** member variables for the class */
public class Blackjack{
  private Card[] player1Deck;
  private Card[] player2Deck;
  private int playerSum;
  private int dealerSum;
  private int playerValue;
  private int dealerValue;
  private int playerSuit;
  private int dealerSuit;

  /** default constructors */
  public Blackjack(){
    playerSum = -1;
    dealerSum = -1;
    playerValue = -1;
    dealerValue = -1;
    playerSuit = -1;
    dealerSuit = -1;
  }

  /** The play method
  *This is where the logic of Blackjack occurs */
  public void play(){
    Deck d = new Deck();
    Card player1Card = new Card();
    Card player2Card = new Card();

    /** deals two cards to player */
    for(int i = 0; i < 2; i++){
      player1Card = d.Deal();
      playerValue = player1Card.getValue();

      /** handling face cards and ace card when first called */
      if(playerValue >= 10){
        playerValue = 10;
      }if(playerValue == 1){
        playerValue = 11;
      }

      playerSuit = player1Card.getSuit();
      playerSum += playerValue;
      System.out.print("You have the cards: ");
      System.out.println(player1Card.toString(playerValue, playerSuit));
    }
    playerSum += 1;

    player2Card = d.Deal();
    dealerValue = player2Card.getValue();

    if(dealerValue >= 10){
      dealerValue = 10;
    }if(dealerValue == 1){
      dealerValue = 11;
    }

    dealerSuit = player2Card.getSuit();
    dealerSum += (dealerValue + 1);
    System.out.print("The dealer has the card: ");
    System.out.println(player2Card.toString(dealerValue, dealerSuit));

    main: while(playerSum < 21 && dealerSum < 21){
      Scanner sin = new Scanner(System.in);
      System.out.print("Do you hit or stand: ");
      String choice = sin.nextLine();

      if(choice.equals("hit")){
        player1Card = d.Deal();
        playerValue = player1Card.getValue();
        if(playerValue >= 10){
          playerValue = 10;
        }

        playerSuit = player1Card.getSuit();
        playerSum += (playerValue);
        System.out.print("You have the card: ");
        System.out.println(player1Card.toString(playerValue, playerSuit));
        System.out.println("Your total is: " + playerSum);

        if(playerSum > 21){
          System.out.println("You went over 21! You lost!");
          break main;
        }else if(playerSum == 21){
          System.out.println("You got Blackjack! You win!");
          break main;
        }else{
          continue main;
        }

      }if(choice.equals("stand")){
        while(dealerSum < 17){
          player2Card = d.Deal();
          dealerValue = player2Card.getValue();

          if(dealerValue >= 10){
            dealerValue = 10;
          }
          dealerSuit = player2Card.getSuit();
          dealerSum += (dealerValue + 1);
        }

        if(dealerSum > 21){
          System.out.println("You won! The dealer went over 21!");
          break main;
        }
        if(playerSum > dealerSum){
          System.out.println("You won! Your total was greater than the dealer");
          break main;
        }if(playerSum < dealerSum){
          System.out.println("You lost! The dealer's total was higher");
          break main;
        }else{
          System.out.println("Tie! You and the dealer tied points!");
          break main;
        }
      }
    }
  }

  /** Calling of the main method to play the game */
  public static void main(String[]args){
    Blackjack b = new Blackjack();
    b.play();
  }
}
