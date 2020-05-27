package modeltest;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.CardSuit;
import model.CardType;
import model.ComputerPlayer;
import model.Hand;
import model.PokerHand;

/**
 * Test the functionality of the ComputerPlayer class
 * 
 * Date : 3/11/16
 * @author CSCI142 Class
 *
 */
public class ComputerPlayerTests
{
	private Hand myHand;
	private Card myCard;

	private ComputerPlayer myComputerPlayer;

	@Before
	public void setup()
	{
		myComputerPlayer = new ComputerPlayer("Jill");
		myHand = myComputerPlayer.getHand();

	}

	/**
	 * Testing to see if the ComputerPlayer is an AI player
	 */
	@Test
	public void testAmAI()
	{
		boolean test = myComputerPlayer.getAmAI();
		assertTrue("The Player should be an AI", test);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a Royal
	 * Flush.
	 */
	@Test
	public void testRoyalFlush()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.ACE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.QUEEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Royal Flush! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a Straight
	 * Flush.
	 */
	@Test
	public void testStraightFlush()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.SEVEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.THREE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.SIX, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.FIVE, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Straight Flush! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a Four of
	 * a Kind.
	 */
	@Test
	public void testFourKind()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Four of a Kind! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a Full
	 * House.
	 */
	@Test
	public void testFullHouse()
	{
		myCard = new Card(CardSuit.SPADES, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.QUEEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.QUEEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.QUEEN, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Full House! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a Flush.
	 */
	@Test
	public void testFlush()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.TWO, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.SEVEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Flush! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if any card was discarded when the computer has a
	 * Straight.
	 */
	@Test
	public void testStraight()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.FIVE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.SEVEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.SIX, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.EIGHT, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Straight! Should not discard at all!", size == 0);
	}

	/**
	 * Testing to see if the correct cards were discarded when the computer has
	 * a Three of a Kind.
	 */
	@Test
	public void testThreeKind()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Three of a Kind! Should discard the other 2!",
				size == 2 && discards.contains(3) && discards.contains(4));
	}

	/**
	 * Testing to see if the correct cards were discarded when the computer has
	 * a Two Pairs.
	 */
	@Test
	public void testTwoPairs()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a Two Pairs! Should discard the other 1!", size == 1 && discards.contains(4));
	}

	/**
	 * Testing to see if the correct cards were discarded when the computer has
	 * a One Pair.
	 */
	@Test
	public void testOnePair()
	{
		myCard = new Card(CardSuit.HEARTS, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.TEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.FIVE, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.DIAMONDS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a One Pair! Should discard the other 3!",
				size == 3 && discards.contains(0) && discards.contains(3) && discards.contains(4));
	}

	/**
	 * Testing to see if the correct cards were discarded when the computer has
	 * a High Card.
	 */
	@Test
	public void testHighCard()
	{
		myCard = new Card(CardSuit.DIAMONDS, CardType.SEVEN, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.SPADES, CardType.FOUR, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.CLUBS, CardType.EIGHT, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.JACK, null);
		myHand.add(myCard);

		myCard = new Card(CardSuit.HEARTS, CardType.KING, null);
		myHand.add(myCard);

		myHand.orderCards();
		Vector<Integer> discards = myComputerPlayer.selectCardsToDiscard();

		int size = discards.size();

		assertTrue("It's a High Card! Should discard the lowest 3!",
				size == 3 && discards.contains(0) && discards.contains(1) && discards.contains(2));
	}

}
