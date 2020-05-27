package model;

import java.util.Vector;

public class Deck
{
	private Vector<Card> myCards;
	private Vector<Card> myCardsDrawn;
	private int myFullDeckSize;

	public Deck()
	{
		myCards = new Vector<Card>();
		
		//Adds a card for every CardSuit & CardType enumeration
		for (CardSuit s : CardSuit.values())
		{
			for (CardType t : CardType.values())
			{
				myCards.add(new Card(s, t, null));
			}
		}
		
		myCardsDrawn = new Vector<Card>();
		myFullDeckSize = 52;
	}

	public boolean constructDeck()
	{
		return false;
	}

	/*
	 * Returns null if deck size is 0
	 * 
	 * Adds card to cardsDrawn vector, then removes it from myCards vector
	 */
	public Card draw()
	{
		if (this.getFullDeckSize() == 0) {
			return null;
		}
		else
		{
			myCardsDrawn.add(this.getCards().lastElement());
			myCards.remove(myFullDeckSize-1);
			
			myFullDeckSize = myFullDeckSize - 1;
			
			return myCardsDrawn.lastElement();
		}
	}

	public boolean shuffle()
	{
		return false;
	}
	
	public int getFullDeckSize()
	{
		return myFullDeckSize;
	}
	
	/*
	 * Add cards to vector until full deck size is reached
	 */
	public Vector<Card> getCards()
	{
		return myCards;
	}

	public String toString()
	{
		return null;
	}

	public Object clone()
	{
		return new Deck();
	}
}
