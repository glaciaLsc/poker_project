package modeltest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CardTests.class, ComputerPlayerTests.class, DeckTests.class, HandTests.class, PlayerTests.class, PokerHandTests.class,
		PokerModelTests.class })

/**
 * Class to test the functionality of all classes under the model
 * 
 * Date : 3/11/16
 * 
 * @author CSCI142 Class
 *
 */
public class AllTests
{

}