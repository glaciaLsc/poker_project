package model;

import java.awt.Image;

public class Card 
{
  private CardSuit mySuit;
  private CardType myType;
  private Image myImage;
  private boolean myIsSelected;
  private boolean myIsFaceUp;

  public Card(CardSuit suit, CardType type, Image image) 
  {
	  mySuit = suit;
	  myType = type;
	  myImage = image;
  }

  /*
   * Checks current faceUp value and reverts it
   */
  public void flip() 
  {
	  if (myIsFaceUp == false)
	  {
		  myIsFaceUp = true;
	  }
	  else
	  {
		  myIsFaceUp = false;
	  }
  }

  public boolean isFaceUp() 
  {
	  return myIsFaceUp;
  }

  public boolean isSelected() 
  {
	  return myIsSelected;
  }

  /*
   * Checks current isSelected value and reverts it
   */
  public void toggleSelected() 
  {
	  if (myIsSelected == false)
	  {
		  myIsSelected = true;
	  }
	  else
	  {
		  myIsSelected = false;
	  }
  }

  /*
   * Returns specific values according to cardType/cardSuit discrepancies between two cards
   */
  public int compareTo(Card card) 
  {
	  if (myType == card.getType())
	  {
		  return 0;
	  }
	  else if (mySuit == card.getSuit() && myType != card.getType())
	  {
		  return -1;
	  }
	  else
	  {
		  return 1;
	  }
  }

  public Object clone() 
  {
	  return null;
  }

  public String toString() 
  {
	  return null;
  }

  public CardSuit getSuit()
  {
	  return mySuit;
  }
  
  public CardType getType()
  {
	  return myType;
  }
  
  public Image getImage()
  {
	  return myImage;
  }
  
}