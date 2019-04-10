/** This is the class Card */

public class Card {

    /** The member variables of the class Card*/
    private int m_value;
    private int m_suit;
    private String [] m_valueArray = {"0", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String [] m_suitArray = {"Spades", "Hearts", "Diamonds", "Clubs"};

    /**default constructor */
    public Card(){
      m_value = -1;
      m_suit = -1;
    }

    /**overload constructor */
    public Card(int v, int s){
      m_suit = s;
      m_value = v;
    }


    /** The accessor for the value of a card
    *@return the value */

    public int getValue(){
      return m_value;
    }

    /** The accessor for the value of a card
    *@return the suit */

    public int getSuit(){
      return m_suit;
    }

    /** The toString method.
    *Was used in order to test whether the Card class worked correctly
    *@return a string of the value and suit */
    public String toString(int v1, int s1){
      String s = "";
      String value = m_valueArray[v1];
      String suit = m_suitArray[s1];
      s += value;
      s += " " + "of" + " ";
      s += suit;
      return s;
    }
}
