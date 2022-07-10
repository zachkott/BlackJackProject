package com.skilldistillery.blackjack.entities;

public class Guest extends Player {

	// every guest will have a black jack hand
	private BlackJackHand hand;

	// No arg ctor
	public Guest() {}

//	public Guest(String name, Hand hand) {
//		super(name, hand);
//	}

	public Guest(BlackJackHand hand) {
		super();
		this.hand = hand;
	}


	// method that will display the total value of the guests hand
	public int handTotal() {
		return hand.getHandValue();
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
}
