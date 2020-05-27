package modeltest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ComputerPlayer;
import model.Player;
/**
 * Test the functionality of the Player class
 * 
 * Date : 3/11/16
 * 
 * @author CSCI142 Class
 *
 */
public class PlayerTests
{
	private Player myPlayerDefault;
	private Player myBadNamePlayer;
	private Player myPlayer;
	
	@Before
	public void setup()
	{
		myPlayerDefault = new Player("Bubba");
	}
	
	/**
	 * Testing to see if the Player is an AI or not by calling the .getAmAI()
	 * Function
	 */
	@Test
	public void testAmAI()
	{
		Player myPlayer = new Player();
		boolean test = myPlayer.getAmAI();
		assertFalse("The Player should not be an AI", test);
	}

	@Test
	public void testDefaultName()
	{
		myPlayer = new ComputerPlayer(null);
		String defaultTest = myPlayer.getName();
		boolean works = defaultTest.equals("JohnCena");
		
		assertTrue("Player called without name should be named JohnCena", works);
	}
	
	@Test
	public void testValidateName()
	{
		boolean valid = true;
		valid = valid && !myPlayerDefault.validateName("John Smith");
		valid = valid && !myPlayerDefault.validateName("3");
		valid = valid && !myPlayerDefault.validateName("!_+#");
		valid = valid && myPlayerDefault.validateName("foo");
		
		assertTrue("Only the name with no special characters should work.", valid);
	}
	
	@Test
	public void testConstructedName()
	{
		boolean works = true;
		String validName = "foo";
		myPlayer = new Player(validName);
		String testedName = myPlayer.getName();
		
		works = works && validName.equals(testedName);
		
		String badName = "B4d Name!";
		myBadNamePlayer = new Player(badName);
		String badTest = myBadNamePlayer.getName();
		works = works && !badName.equals(badTest);
		
		assertTrue("Constructor should set name when name valid and not when invalid",works);
	}
	
	@Test
	public void testIncrementNumberWins()
	{
		Player myPlayer = new Player();
		int wins1 = myPlayer.getNumberWins();
		myPlayer.incrementNumberWins();
		int wins2 = myPlayer.getNumberWins();
		
		boolean worked = (wins2>wins1);
		
		assertTrue("When win is incremented number wins should increase.", worked);
	}
}
