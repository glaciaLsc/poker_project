package modeltest;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardSuit;
import model.CardType;
import model.Hand;
import model.PokerHand;
import model.PokerHandRanking;

/**
 * Test the functionality of the PokerHand class
 * 
 * Date : 3/11/16
 * 
 * @author CSCI142 Class
 *
 */

public class PokerHandTests
{
	private PokerHand myHand;

	@Before
	public void setup()
	{
		myHand = new PokerHand(5);
	}

	/**
	 * Testing to see if multiple copies of one card are put into a hand, if
	 * they will a PokerHand condition
	 */
	@Test
	public void testIfWrongFourOfKind()
	{
		myHand.add(new Card(CardSuit.CLUBS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.FIVE, null));

		boolean test = myHand.isFourOfKind();
		assertFalse("Same four cards, should not work", test);
	}

	/**
	 * Testing to see if .isThreeOfKing works for .isFourOfKing, which it should
	 * not because there are four of the same card
	 */
	
	@Test
	public void testIfCountedRight()
	{
		myHand.add(new Card(CardSuit.CLUBS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.FIVE, null));

		boolean test = myHand.isThreeOfKind();
		assertFalse("Should not work, should be 4 of a kind", test);

	}
	
	/**
	 * Test if it's a Royal Flush.
	 */
	
	@Test
	public void testIfRoyalFlush()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.ACE, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.QUEEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.JACK, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isRoyalFlush();
		assertTrue("It should be a Royal Flush!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Royal Flush!", ranking == PokerHandRanking.ROYAL_FLUSH);
	}
	
	/**
	 * Test if it's a Straight Flush.
	 */
	
	@Test
	public void testIfStraightFlush()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.SEVEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.THREE, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.SIX, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.FIVE, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isStraightFlush();
		assertTrue("It should be a Straight Flush!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Straight Flush!", ranking == PokerHandRanking.STRAIGHT_FLUSH);
	}
	
	/**
	 * Test if it's a Four of a Kind.
	 */
	
	@Test
	public void testIfFourKind()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.TEN, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.KING, null));
		
		myHand.orderCards();

		boolean test = myHand.isFourOfKind();
		assertTrue("It should be a Four of a Kind!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Four of Kind!", ranking == PokerHandRanking.FOUR_OF_KIND);
	}
	
	/**
	 * Test if it's a Full House.
	 */
	
	@Test
	public void testIfFullHouse()
	{
		myHand.add(new Card(CardSuit.SPADES, CardType.TEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.QUEEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.QUEEN, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.QUEEN, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isFullHouse();
		assertTrue("It should be a Full House!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Full House!", ranking == PokerHandRanking.FULL_HOUSE);
	}
	
	/**
	 * Test if it's a Flush.
	 */
	
	@Test
	public void testIfFlush()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.TWO, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.SEVEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isFlush();
		assertTrue("It should be a Flush!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Flush!", ranking == PokerHandRanking.FLUSH);
	}
	
	/**
	 * Test if it's a Straight.
	 */
	
	@Test
	public void testIfStraight()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.FIVE, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.SIX, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.SEVEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.EIGHT, null));
		
		myHand.orderCards();

		boolean test = myHand.isStraight();
		assertTrue("It should be a Straight!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Straight!", ranking == PokerHandRanking.STRAIGHT);
	}
	
	/**
	 * Test if it's a Three of a Kind.
	 */
	
	@Test
	public void testIfThreeKind()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.TEN, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.JACK, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isThreeOfKind();
		assertTrue("It should be a Three of a Kind!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Three of a Kind!", ranking == PokerHandRanking.THREE_OF_KIND);
	}
	
	/**
	 * Test if it's a Two Pairs.
	 */
	
	@Test
	public void testIfTwoPairs()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.JACK, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.JACK, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isTwoPair();
		assertTrue("It should be a Two Pair!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be Two Pair!", ranking == PokerHandRanking.TWO_PAIR);
	}
	
	/**
	 * Test if it's a Pair.
	 */
	
	@Test
	public void testIfOnePair()
	{
		myHand.add(new Card(CardSuit.HEARTS, CardType.TEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.TEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.FIVE, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.JACK, null));
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isPair();
		assertTrue("It should be a Pair!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be a Pair!", ranking == PokerHandRanking.PAIR);
	}
	
	/**
	 * Test if it's a HighCard.
	 */
	
	@Test
	public void testIfHighCard()
	{
		myHand.add(new Card(CardSuit.DIAMONDS, CardType.SEVEN, null));
		myHand.add(new Card(CardSuit.SPADES, CardType.FOUR, null));
		myHand.add(new Card(CardSuit.CLUBS, CardType.EIGHT, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.JACK, null));
		myHand.add(new Card(CardSuit.HEARTS, CardType.KING, null));
		
		myHand.orderCards();
		
		boolean test = myHand.isHighCard();
		assertTrue("It should be a High Card!", test);
		
		PokerHandRanking ranking = myHand.determineRanking();
		assertTrue("Should be High Card!", ranking == PokerHandRanking.HIGH_CARD);
	}
	
}
