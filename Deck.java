/** This is the class Deck */

import java.util.LinkedList;
import java.util.Random; //importing the Random class

public class Deck {

    /** The member variables of the class Card*/
    private LinkedList<Card> deck = new LinkedList<Card>();
    private int m_index; //includes an index variable in order to keep track of the cards and their index in the LinkedList

    /**default constructor
    *The deck is created here and contains all 52 cards.
    *For the second for loop (the nested one) - the int n starts at 1 since in the Card clas, there is a 0 at index 0 so the cards would all have  index of their face value 
    */
    public Deck(){
      m_index = 0;

      for(int i = 0; i < 4; i++){ //nested for loop to create a deck of cards with all 52 cards
        for(int n = 1; n < 13; n++){
          deck.add(m_index, new Card(n,i));
          m_index++;
			  }
      }
    }

    /**The Deal method
    *It is used to randomly deal a card to a deck called from another class
    *@return a random card
    */
	  public Card Deal(){
      int count = 26;
      Random rand = new Random();
	    int randomCard = rand.nextInt(count-1) + 1; //
      Card c = deck.remove(randomCard);
      return c;
	}
}
