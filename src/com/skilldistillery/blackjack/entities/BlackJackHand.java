package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	// No arg ctor
	public BlackJackHand() {
	}

	// method that will display the current hand value
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			System.out.println(card);
			handValue += card.getValue();
			System.out.println("Hand value:  " + handValue);
		}
		return handValue;
	}

	// boolean method that determines whether or not the hand total is equal to 21
	public boolean isBlackjack() {
		int handTotal = 0;
		for (Card card : cards) {
			handTotal += card.getValue();
		}
		if (handTotal == 21) {
			System.out.println("BlackJack!");
			return true;
		} else {
			return false;
		}
	}

	// boolean method that determines whether or not the hand total is over 21
	public boolean isBust() {
		int handTotal = 0;
		int blackJack = 21;
		for (Card card : cards) {
			handTotal += card.getValue();
		}
		if (handTotal > blackJack) {
			System.out.println("Bust... Better luck next time");
			return true;
		} else {
			return false;
		}
	}

}
