package model;

public class Player
{
	private static final String DEFAULT_NAME = "JohnCena";
	private String myName;
	private int myNumberWins;
	private boolean myAmAI;
	private PokerHand myHand;

	/*
	 * name is set to default
	 */
	public Player()
	{
		myName = DEFAULT_NAME;
	}
	
	/*
	 * Constructor will not set myName variable if name contains special characters
	 * 
	 * If no name is declared, name is set to default
	 */
	public Player(String name)
	{
		if (name == null)
		{
			name = DEFAULT_NAME;
			myName = name;
		}
		else if (name.contains("4") || (name.contains("!") || name.contains(" ")))
		{
			name = "Invalid";
		}
		else
		{
			myName = name;
		}
	}

	/*
	 * Returns false if name contains special characters
	 */
	public boolean validateName(String name)
	{
		if (name.contains("3") || name.contains("!") || name.contains(" "))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	 * Increment existing numberWins value by 1
	 */
	public int incrementNumberWins()
	{
		myNumberWins = myNumberWins + 1;
		
		return myNumberWins;
	}

	public String toString()
	{
		return null;
	}

	public Object clone()
	{
		return null;
	}

	public PokerHand getHand()
	{
		return null;
	}

	public String getName()
	{
		return myName;
	}

	public int getNumberWins()
	{
		return myNumberWins;
	}

	public boolean getAmAI()
	{
		return false;
	}

}
