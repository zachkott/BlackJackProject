package com.skilldistillery.blackjack.entities;

public abstract class Player {

	// Every player has a Name and a Hand
	private String playerName;
	protected Hand playerHand;

	// No arg  ctor
	public Player() {}

	// ctor with name and hand
	public Player(String name, Hand hand) {
		super();
		this.playerName = name;
		this.playerHand = hand;
	}

	
	// getters and setters
	public String getPlayerType() {
		return playerName;
	}

	public void setPlayerType(String playerType) {
		this.playerName = playerType;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	// Idk if this is necessary because i already have handValue in BlackJackHand
//	public void showHand(List<Card> dealtCards) {
//
//		int handValue = 0;
//		for (Card card : dealtCards) {
//			System.out.println(card);
//			handValue += card.getValue();
//
//		}
//		System.out.println("Hand Value: " + handValue);
//	}

}
