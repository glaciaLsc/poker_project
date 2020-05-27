package modeltest;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardSuit;
import model.CardType;
import model.Hand;
import model.PokerHandRanking;

/**
 * Test the functionality of the Hand class
 * 
 * Date : 3/11/16
 * 
 * @author CSCI142 Class
 *
 */
public class HandTests
{
	private Hand myHand;
	private Card myCard;

	@Before
	public void setup()
	{
		myHand = new Hand(5);
	}

	/**
	 * Testing to see if a card has been added by calling the .add() method and
	 * the .contains() method
	 */
	@Test
	public void testAddedCard()
	{
		Card myCard = new Card(CardSuit.SPADES, CardType.TWO, null);
		myHand.add(myCard);
		Vector<Card> test = myHand.getCards();
		boolean equal = (test.contains(myCard));
		assertTrue("The card was added so it should be in the hand", equal);
	}

	/**
	 * Testing to see if you can add more that one of the same card into a hand
	 */
	@Test
	public void testMultipleCards()
	{
		myCard = new Card(CardSuit.CLUBS, CardType.THREE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.SIX, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.EIGHT, null);
		myHand.add(myCard);
		
		myCard = new Card(CardSuit.CLUBS, CardType.THREE, null);
		boolean added = myHand.add(myCard);
		int size = myHand.getCards().size();
		
		assertFalse("Two of the same cards should not be added!", added);
		assertTrue("Too many cards added!", size == 4);
	}

	/**
	 * Testing to see if you can add more than 5 cards to the hand, should not
	 * work
	 */
	@Test
	public void testIfMoreThan5Cards()
	{
		myCard = new Card(CardSuit.CLUBS, CardType.THREE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.TWO, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.SIX, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.EIGHT, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.FIVE, null);
		myHand.add(myCard);

		assertFalse("Added more than 5 cards, which is the max in a Hand", myHand.getCards().size() > 5);

	}

	/**
	 * Testing to see if Hand was ordered correctly.
	 */
	@Test
	public void testIfOrdered()
	{
		myCard = new Card(CardSuit.CLUBS, CardType.THREE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.TWO, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.SIX, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.EIGHT, null);
		myHand.add(myCard);

		myHand.orderCards();
		boolean test = true;
		for (int i = 0; i < myHand.getCards().size() - 1; i++)
		{
			Card cardi = myHand.getCards().get(i);
			Card cardip1 = myHand.getCards().get(i + 1);
			int typei = cardi.getType().getType();
			int typeip1 = cardip1.getType().getType();

			if (typei > typeip1)
			{
				test = false;
				break;
			}
		}
		assertTrue("Hand was sorted!", test);
	}

	/**
	 * Tests if discard() correctly rids of card chosen.
	 */
	@Test
	public void testIfCorrectDiscard()
	{
		Hand hand = new Hand(5);
		
		Card card1 = new Card(CardSuit.SPADES, CardType.ACE, null);
		Card card2 = new Card(CardSuit.SPADES, CardType.KING, null);
		Card card3 = new Card(CardSuit.SPADES, CardType.QUEEN, null);
		Card card4 = new Card(CardSuit.SPADES, CardType.FIVE, null);
		Card card5 = new Card(CardSuit.SPADES, CardType.TWO, null);
		
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
		
		Vector<Integer> v = new Vector<Integer>();
		v.add(3);
		v.add(4);
		Vector <Card> discard = hand.discard(v);
		assertTrue("Should have gotten rid "
				+ "of last two cards in hand",discard.contains(card4)&&discard.contains(card5));
	}
	
	@Test
	/**
	 * Tests if hand rejects cards when full
	 * 
	 */
	public void testAddTooManyCards()
	{
		boolean worked = true;
		Hand fullHand = new Hand(3);
		Card[] cards = new Card[4];
		cards[0] = new Card(CardSuit.CLUBS, CardType.ACE, null);
		cards[1] = new Card(CardSuit.HEARTS, CardType.FIVE, null);
		cards[2] = new Card(CardSuit.DIAMONDS, CardType.TEN, null);
		cards[3] = new Card(CardSuit.SPADES, CardType.NINE, null);
		
		for(int i=0; i<5; i++)
		{
			worked = worked && fullHand.add(cards[i]);
		}
		assertFalse("Add should fail on fourth card", worked);
	}
	
	@Test
	/**
	 * Tests whether cards are correctly ordered after orderCards is called
	 * 
	 */
	public void testOrderCards()
	{
		boolean worked = true;
		Hand orderHand = new Hand(5);
		Card[] cards = new Card[5];
		cards[0] = new Card(CardSuit.CLUBS, CardType.ACE, null);
		cards[1] = new Card(CardSuit.HEARTS, CardType.FIVE, null);
		cards[2] = new Card(CardSuit.DIAMONDS, CardType.TEN, null);
		cards[3] = new Card(CardSuit.SPADES, CardType.NINE, null);
		cards[4] = new Card(CardSuit.HEARTS, CardType.TWO, null);
		
		for(int i=0; i<5; i++)
		{
			orderHand.add(cards[i]);
		}
		orderHand.orderCards();
		
		/*
		 * Checks new order against correct order as determined manually
		 */
		Vector<Card> ordered = orderHand.getCards();
		worked = worked && ordered.get(0) == cards[4];
		worked = worked && ordered.get(1) == cards[1];
		worked = worked && ordered.get(2) == cards[3];
		worked = worked && ordered.get(3) == cards[2];
		worked = worked && ordered.get(4) == cards[0];
		
		assertTrue("Cards should be organized from low type to high with Ace on top", worked);
	}
	
	/**
	 * Tests whether discard gets rid of the correct cards
	 * and whether it actually removes them from the hand
	 * and leaves the correct cards behind.
	 * 
	 */
	@Test
	public void testDiscard()
	{
		boolean worked = true;
		Hand discardHand = new Hand(5);
		Card[] cards = new Card[5];
		cards[0] = new Card(CardSuit.CLUBS, CardType.ACE, null);
		cards[1] = new Card(CardSuit.HEARTS, CardType.KING, null);
		cards[2] = new Card(CardSuit.DIAMONDS, CardType.TEN, null);
		cards[3] = new Card(CardSuit.SPADES, CardType.FOUR, null);
		cards[4] = new Card(CardSuit.HEARTS, CardType.TWO, null);
		
		for(int i=0; i<5; i++)
		{
			discardHand.add(cards[i]);
		}
		discardHand.orderCards();
		
		/*
		 * Discards first, third, and fifth card. Note that due to symmetrical
		 * nature of distribution this will result in same cards being eliminated
		 * after sorting as were in those positions before sorting.
		 */
		
		Vector<Integer> discardIndices = new Vector<Integer>(3);
		discardIndices.add(0);
		discardIndices.add(2);
		discardIndices.add(4);
		
		Vector<Card> discardedCards = discardHand.discard(discardIndices);
		
		worked = worked && discardHand.getCards().size() == 2;
		worked = worked && discardHand.getCards().contains(cards[1]);
		worked = worked && discardHand.getCards().contains(cards[3]);
		assertTrue("Should have those two cards left", worked);
		
		/*
		 * Reset worked to true in case above test fails with worked = false
		 */
		worked = true;
		worked = worked && discardedCards.contains(cards[0]);
		worked = worked && discardedCards.contains(cards[2]);
		worked = worked && discardedCards.contains(cards[4]);
		assertTrue("Should contain specified cards", worked);
	}
}
