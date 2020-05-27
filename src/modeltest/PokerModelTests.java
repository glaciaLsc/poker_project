package modeltest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ComputerPlayer;
import model.Deck;
import model.Hand;
import model.Player;
import model.PokerModel;
/**
 * Test the functionality of the PokerModel class
 * 
 * Date : 2/11/16
 * 
 * @author CSCI142 Class
 *
 */
public class PokerModelTests
{
	private PokerModel myPokerModel;
	private Player myPlayer;

	@Before
	public void setup()
	{
		myPlayer = new Player("BooBoo");
		myPokerModel = new PokerModel(myPlayer);
	}

	/**
	 * Testing to see if the game has been successfully reset by calling
	 * .resetGame()
	 */
	@Test
	public void testIfReset()
	{
		boolean test = myPokerModel.resetGame();
		assertTrue("The game has been reset", test);
	}
	
	/**
	 * Testing to see if you added the proper amount of card in the Hand.
	 */
	@Test
	public void dealCardsProperAmount()
	{
		myPokerModel.resetGame();
		myPokerModel.dealCards();
		
		for (int i=0; i<2; i++)
		{
			Player player = myPokerModel.getPlayer(i);
			Hand myHand = player.getHand();
			int numCards = myHand.getNumberCardsInHand();
			
			assertTrue("Wrong number of Cards.", numCards==5);
		}
	}
	
	/**
	 * Test if the switchTurns() method works correctly.
	 */
	@Test
	public void testIfTurnsSwitch()
	{
		/*
		 * Get player up, switch turns, get other player up.
		 */
		Player player1 = myPokerModel.getPlayerUp();
		myPokerModel.switchTurns();
		Player player2 = myPokerModel.getPlayerUp();
		boolean switched = (player1 == player2);
		assertFalse("Switched turns but somehow same player is up.", switched);
	}

	/**
	 * Tests if switchTurns() can switch between computer and player's turns.
	 */
	@Test
	public void testIfSwitchTurnsCorrect() 
	{
		/**
		 * Starts new game and deals cards to each. Checks if Player[0] is
		 * first.
		 */
		myPokerModel.resetGame();
		myPokerModel.dealCards();
		
		assertTrue("Should be Player's turn", myPokerModel.getIndexPlayerUp() == 0);
		assertTrue("Should be Player's turn", myPokerModel.getPlayerUp().getName() == myPlayer.getName());

		/**
		 * Checks if switchTurns() changes index to computerPlayer
		 */
		myPokerModel.switchTurns();
		assertTrue("Should be Computer's turn", myPokerModel.getIndexPlayerUp() == 1);
		assertFalse("Should be Computer's turn", myPokerModel.getPlayerUp().getName() == myPlayer.getName());
	}

	/**
	 * Tests if resetGame() clears all hands.
	 */
	@Test
	public void testIfResetsCorrectly() 
	{
		myPokerModel.dealCards();
		myPokerModel.resetGame();
		Hand hand = myPlayer.getHand();
		int numCards = hand.getNumberCardsInHand();
		assertTrue("Player hand should be empty",numCards==0);

	}

}
