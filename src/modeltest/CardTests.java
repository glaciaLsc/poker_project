package modeltest;

import model.Card;
import model.CardSuit;
import model.CardType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the functionality of the Card class
 * 
 * Date : 3/11/16
 * @author CSCI142 class
 */
public class CardTests
{
	private Card myCard;

	@Before
	public void setup()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.QUEEN, null);

	}

	/**
	 * Test to see if the card has been correctly flipped
	 */
	@Test
	public void testIfFlipped()
	{

		boolean test = myCard.isFaceUp();
		myCard.flip();
		assertTrue("The card was not flipped", test != myCard.isFaceUp());
	}
	
	/**
	 * Test making cards and comparing them
	 * Some same & some different
	 */
	
	
	/**
	 * Ace of Hearts compared to Ace of Spades (different suits, same value)
	 */
	@Test
	public void sameValueDifferentSuit() {
		Card card1 = new Card(CardSuit.HEARTS, CardType.ACE, null);
		Card card2 = new Card(CardSuit.SPADES, CardType.ACE, null);
		assertTrue(card1.compareTo(card2) == 0);
		
	}

	/**
	 * Jack of Diamonds compared to Jack of Diamonds (same)
	 */
	@Test
	public void sameAll() {
		Card card1 = new Card(CardSuit.DIAMONDS, CardType.JACK, null);
		Card card2 = new Card(CardSuit.DIAMONDS, CardType.JACK, null);
		assertTrue(card1.compareTo(card2) == 0);
	}
	
	
	/**
	 * Seven of Spades compared to Six of Spades (same suit, different value)
	 */
	
	@Test
	public void sameSuitDifferentValue() {
		Card card1 = new Card(CardSuit.SPADES, CardType.SIX, null);
		Card card2 = new Card(CardSuit.SPADES, CardType.SEVEN, null);
		assertTrue(card1.compareTo(card2) == -1);
	}
	
	/**
	 * Ace of Hearts compared to King of Diamonds (Fringe case)
	 */
	@Test
	public void differentAll() {
		Card card1 = new Card(CardSuit.HEARTS, CardType.ACE, null);
		Card card2 = new Card(CardSuit.DIAMONDS, CardType.KING, null);
		assertTrue(card1.compareTo(card2) == 1);
	}
	
	/**
	 * Test if card is selected and test toggle method
	 */
	
	/**
	 * Test if is selected when constructed
	 */
	@Test
	public void isSelected() {
		Card card1 = new Card(CardSuit.HEARTS, CardType.ACE, null);
		assertFalse(card1.isSelected());
	}
	
	/**
	 * Test toggling once
	 */
	@Test
	public void toggleSelectedOnce() {
		Card card1 = new Card(CardSuit.HEARTS, CardType.ACE, null);
		card1.toggleSelected();
		assertTrue(card1.isSelected());
	}
	
	/**
	 * Test toggling twice
	 */
	@Test
	public void toggleSelected2Times() {
		Card card1 = new Card(CardSuit.HEARTS, CardType.ACE, null);
		for (int i = 0; i < 2 ; i++){
			card1.toggleSelected();	
		}
		assertFalse(card1.isSelected());
	}
}
