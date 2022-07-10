package com.skilldistillery.blackjack.entities;

public class Guest {

	// every guest will have a black jack hand
	private BlackJackHand hand = new BlackJackHand();
	private int handValue;

	public Guest() {
		super();
		hand = new BlackJackHand();
	}

	// method that will display the total value of the guests hand
	public int handTotal() {
		handValue = hand.getHandValue();
		return handValue;
	}

	// method that will be called if the hand value is over 21
	public boolean handIsBust() {
		return hand.isBust();
	}

	// method that will be called if the hand value is equal to 21
	public boolean handIsBlackJack() {
		return hand.isBlackjack();
	}

	// getters and setters
	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public void showHand() {
		int handValue = 0;
		System.out.println("Your Hand: ");
		for (Card cards : hand.cards) {
			System.out.println(cards);
			handValue += cards.getValue();

		}
		System.out.println("Hand Value: " + handValue + "\n");
	}

}
