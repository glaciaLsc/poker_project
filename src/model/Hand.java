package model;

import java.util.Vector;

public class Hand
{
	private int myMaxNumberCards;
	protected Vector<Card> myCards;

	public Hand(int maxNum)
	{
		myMaxNumberCards = maxNum;
		myCards = new Vector<Card>();
	}

	/*
	 * If card being added is duplicate of existing card, the new card will not be added
	 * 
	 * If number of cards meets or exceeds declared maxNum value, no card will be added to value
	 */
	public boolean add(Card card)
	{
		for (int i=0; i < myCards.size(); i++)
		{
			if (card.compareTo(myCards.elementAt(i)) == 0 &&
				card.getSuit() == myCards.elementAt(i).getSuit())
			{
				return false;
			}
		}
		
		if (card == null)
		{
			return false;
		}
		else
		{
			
			if (myCards.size() >= myMaxNumberCards)
			{
				return false;
			}
			else
			{
				myCards.add(card);
				
				return true;
			}
			
		}
	}

	/*
	 * For every element of the indices vector, add the card with the matching index
	 */
	public Vector<Card> discard(Vector<Integer> indices)
	{
		Vector<Card> myCardsDiscarded = new Vector<Card>();
		
		for (int i=0; i < indices.size(); i++)
		{
			myCardsDiscarded.add(myCards.elementAt(indices.elementAt(i)));
		}
		
		return myCardsDiscarded;
	}

	public String toString()
	{
		return null;
	}

	public void orderCards()
	{
	}

	public int getNumberCardsInHand()
	{
		return myCards.size();
	}

	public Vector<Card> getCards()
	{
		return myCards;
	}
	
}
