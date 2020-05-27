package model;

public class PokerHand extends Hand
{

	private int myNumberCards;
	private int myMaxNumberCards;
	private int myRanking;

	public PokerHand(int maxNum)
	{
		super(maxNum);
		
		if (this.isHighCard())
		{
			myRanking = 1;
		}
		if (this.isPair())
		{
			myRanking = 2;
		}
		if (this.isTwoPair())
		{
			myRanking = 3;
		}
		if (this.isThreeOfKind())
		{
			myRanking = 4;
		}
		if (this.isStraight())
		{
			myRanking = 5;
		}
		if (this.isFlush())
		{
			myRanking = 6;
		}
		if (this.isFullHouse())
		{
			myRanking = 7;
		}
		if (this.isFourOfKind())
		{
			myRanking = 8;
		}
		if (this.isStraightFlush())
		{
			myRanking = 9;
		}
		if (this.isRoyalFlush())
		{
			myRanking = 10;
		}
	}

	public PokerHandRanking determineRanking()
	{
		if (this.getRanking() == 2)
		{
			return PokerHandRanking.PAIR;
		}
		else if (this.getRanking() == 3)
		{
			return PokerHandRanking.TWO_PAIR;
		}
		else if (this.getRanking() == 4)
		{
			return PokerHandRanking.THREE_OF_KIND;
		}
		else if (this.getRanking() == 5)
		{
			return PokerHandRanking.STRAIGHT;
		}
		else if (this.getRanking() == 6)
		{
			return PokerHandRanking.FLUSH;
		}
		else if (this.getRanking() == 7)
		{
			return PokerHandRanking.FULL_HOUSE;
		}
		else if (this.getRanking() == 8)
		{
			return PokerHandRanking.FOUR_OF_KIND;
		}
		else if (this.getRanking() == 9)
		{
			return PokerHandRanking.STRAIGHT_FLUSH;
		}
		else if (this.getRanking() == 10)
		{
			return PokerHandRanking.ROYAL_FLUSH;
		}
		else
		{
			return PokerHandRanking.HIGH_CARD;
		}
	}

	public int compareTo(PokerHand pokerHand)
	{
		return 0;
	}

	public String toString()
	{
		return null;
	}

	public int getRanking()
	{
		return myRanking;
	}

	public int getNumberCards()
	{
		return 0;
	}

	public int getMaxNumberCards()
	{
		return 0;
	}

	public boolean isHighCard()
	{
		return true;
	}

	public boolean isPair()
	{
		return false;
	}

	public boolean isTwoPair()
	{
		return false;
	}

	public boolean isThreeOfKind()
	{
		return false;
	}

	public boolean isStraight()
	{
		return false;
	}

	public boolean isFlush()
	{
		return false;
	}

	public boolean isFullHouse()
	{
		return false;
	}

	public boolean isFourOfKind()
	{
		return false;
	}

	public boolean isStraightFlush()
	{
		return false;
	}

	public boolean isRoyalFlush()
	{
		return false;
	}

}
