package modeltest;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardSuit;
import model.CardType;
import model.Deck;

/**
 * Deck Test cases to test the functionality of the Deck class
 * 
 * Date : 3/11/16
 * 
 * @author CSCI142 Class
 * 
 *
 */
public class DeckTests
{

	private Deck myDeck;

	@Before
	public void setup()
	{
		myDeck = new Deck();
	}

	private CardType[] cardValue = 
	{
		CardType.ACE, CardType.TWO, CardType.THREE, 
		CardType.FOUR, CardType.FIVE, CardType.SIX, 
		CardType.SEVEN, CardType.EIGHT, CardType.NINE, 
		CardType.TEN, CardType.JACK, CardType.QUEEN, CardType.KING
	};
	
	private CardSuit[] suit =
	{ 
		CardSuit.CLUBS, CardSuit.DIAMONDS, CardSuit.HEARTS, CardSuit.SPADES
	};
	
	
	/**
	 * Check that ALL cards are present (in no particular order)
	 */
	
	@Test
	public void hasAllCardsTest() 
	{
		Vector<Card> cards = myDeck.getCards();
		
		for (CardSuit s : CardSuit.values())
		{
			for (CardType c : CardType.values())
			{
				boolean found = false;
				for (Card card : cards)
				{
					if (card.getSuit() == s && card.getType() == c)
					{
						found = true;
					}
				}
				assertTrue(""+s+" "+c+" not found", found);
			}
		}
		
	}
	
	/**
	 * Test deck returns null when empty
	 */
	
	@Test
	public void returnsNullWhenEmpty() 
	{
		Vector<Card> cardsDrawn = new Vector<Card>();
		for (int i = 0; i < myDeck.getFullDeckSize(); i++)
		{
			cardsDrawn.add(myDeck.draw());
		}
		assertTrue(myDeck.draw() == null);
	}
	
	/**
	 * draw one card, check it's NOT in deck
	 */

	@Test
	public void cardNotInDeckAfterDrawn()
	{
		Card card = myDeck.draw();
		assertFalse(myDeck.getCards().contains(card));
	}
	
	/**
	 * clone deck, assert they are the same
	 */
	
	@Test
	public void compare2ClonedDecks()
	{
		Deck deck2 = (Deck)myDeck.clone();
		for (int i = 0; i <  myDeck.getFullDeckSize(); i++)
		{
			assertTrue(myDeck.getCards().get(i).compareTo(deck2.getCards().get(i)) == 0);
		}
	}
	
	/**
	 * Make sure that 52 cards are in the deck.
	 */
	@Test
	public void allCardsInDeck()
	{
		int deckSize = myDeck.getCards().size();
		
		assertTrue(deckSize ==  myDeck.getFullDeckSize());
	}
	
	/**
	 * Test to make sure that shuffling works.
	 */
	@Test
	public void shuffleWorks()
	{
		Deck deckClone = (Deck)myDeck.clone();
		Vector<Card> initialSet, newSet;
		int deckSize, numberOfEqualCards = 0;
		deckSize = myDeck.getCards().size();
		
		//Get the initial set of cards (before the deck is shuffled)
		initialSet = myDeck.getCards();
		
		//Shuffle the deck
		deckClone.shuffle();
		
		//Get the newly shuffled set of cards
		newSet = deckClone.getCards();
		
		/*
		 * Run a loop that iterates through the deck
		 * and compares the initial card to the new 
		 * card in the same position. This will keep 
		 * track of how many cards were either shuffled 
		 * back into the same spot or were not shuffled 
		 * to begin with.
		 */
		for(int i = 0; i < deckSize; i++)
		{
			Card initialCard, newCard;
			CardSuit initialSuit, newSuit;
			boolean suitsEqual = false, valuesEqual = false;
			CardType initialValue, newValue;
			
			//Get the cards
			initialCard = initialSet.get(i);
			newCard = newSet.get(i);
			
			//Get the suits
			initialSuit = initialCard.getSuit();
			newSuit = newCard.getSuit();
			
			//Get the values
			initialValue = initialCard.getType();
			newValue = newCard.getType();
			
			//Are the suits equal?
			if(initialSuit.compareTo(newSuit) == 0)
			{
				suitsEqual = true;
			}
			
			//Are the values equal?
			if(initialValue.compareTo(newValue) == 0)
			{
				valuesEqual = true;
			}
			
			//If the suit and value are equal, the cards are equal
			//so increase the counter
			if(suitsEqual && valuesEqual)
			{
				numberOfEqualCards++;
			}
		}
		
		/*
		 * Assert that at least one card (and therefore
		 * at least 2 cards) was shuffled into a different
		 * position.
		 */
		assertTrue(numberOfEqualCards < deckSize);
	}
		
	/*
	 * *********************************
	 * 
	 * Check to make sure all card suits
	 * and values appear in the deck.
	 * (13 of each suit should appear,
	 * and 4 of each value should appear.)
	 * 
	 * *********************************
	 */
	
	/**
	 * Check to make sure that all aces, 
	 * jacks, queens, kings, and numbers
	 * 2-10 appear four times each.
	 */
	@Test
	public void allValues()
	{
		Vector<Card> deckSet = myDeck.getCards();
		final int NUMBER_OF_VALUES = 14;
		
		/*
		 * This loop iterates through all values and counts
		 * how many times each value appears in the deck.
		 */
		for(int i = 2; i <= NUMBER_OF_VALUES; i++)
		{
			int valueFrequency = this.checkValueFrequency(deckSet, i);
			assertTrue(valueFrequency == 4);		
		}
	}
	
	/**
	 * Check to make sure that spades appears thirteen times.
	 */
	@Test
	public void allSpades()
	{
		Vector<Card> deckSet = myDeck.getCards();
		int numberOfSpades = this.checkSuitFrequency(deckSet, "Spades");
		assertTrue(numberOfSpades == 13);
	}
	
	/**
	 * Check to make sure that diamonds appears thirteen times.
	 */
	@Test
	public void allDiamonds()
	{
		Vector<Card> deckSet = myDeck.getCards();
		int numberOfDiamonds = this.checkSuitFrequency(deckSet, "Diamonds");
		
		assertTrue(numberOfDiamonds == 13);
	}
	
	/**
	 * Check to make sure that hearts appears thirteen times.
	 */
	@Test
	public void allHearts()
	{
		Vector<Card> deckSet = myDeck.getCards();
		int numberOfHearts = this.checkSuitFrequency(deckSet, "Hearts");
		
		assertTrue(numberOfHearts == 13);
	}
	
	/**
	 * Check to make sure that clubs appears thirteen times.
	 */
	@Test
	public void allClubs()
	{
		Vector<Card> deckSet = myDeck.getCards();
		int numberOfClubs = this.checkSuitFrequency(deckSet, "Clubs");
		
		assertTrue(numberOfClubs == 13);
	}
	
	/**
	 * Check how many times a certain suit appears in a set of cards
	 * @param cardSet the set of cards
	 * @param matchSuit the suit that will be matched to the cards in the set
	 * @return how many times the suit appeared in the set
	 */
	private int checkSuitFrequency(Vector<Card> cardSet, String matchSuit)
	{
		int counter = 0;
		int setSize = cardSet.size();
		
		/*
		 * Run a loop that iterates through every card in the
		 * set and counts how many times a card's suit matches
		 * with the matchSuit.
		 */
		for(int i = 0; i < setSize; i++)
		{
			Card currentCard = cardSet.get(i);
			String currentSuit = currentCard.getSuit().getSuit();
			
			if(currentSuit.compareTo(matchSuit) == 0)
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 * Check how many times a certain card value appears in a set of cards
	 * @param cardSet the set of cards
	 * @param matchValue the card value that will be matched to the cards in the set
	 * @return how many times the card value appeared in the set
	 */
	private int checkValueFrequency(Vector<Card> cardSet, int matchValue)
	{
		int counter = 0;
		int setSize = cardSet.size();
		
		/*
		 * Run a loop that iterates through every card in the
		 * set and counts how many times a card's value matches
		 * with the matchValue.
		 */
		for(int i = 0; i < setSize; i++)
		{
			Card currentCard = cardSet.get(i);
			int currentValue = currentCard.getType().getType();
			
			if(currentValue == matchValue)
			{
				counter++;
			}
		}
		
		return counter;
	}

}
