package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {

	// Every dealer will have a deck and black jack hand
	private Deck deck;
	private BlackJackHand hand;

	// No arg ctor
	public Dealer() {}

	public Dealer(BlackJackHand hand) {
		super();
		this.hand = hand;
	}

	// method that allows the dealer to shuffle the deck
	public void shuffleDeck() {
		deck.shuffle();
	}

	// method that deals hand to dealer
	public void dealHandToSelf() {
		BlackJackHand dealerHand = new BlackJackHand();

		Card first = deck.dealCard();
		Card second = deck.dealCard();

		dealerHand.addCard(first);
		dealerHand.addCard(second);

		System.out.println(dealerHand);
	}

	// method that deals hand to guest
	public void dealHandToGuest() {
		BlackJackHand playerHand = new BlackJackHand();

		Card first = deck.dealCard();
		Card second = deck.dealCard();

		playerHand.addCard(first);
		playerHand.addCard(second);

		System.out.println(playerHand);
	}

	// method that will ad card to player hand if they choose to hit
	public void hit(Player player) {
		player.getPlayerHand().addCard(deck.dealCard());
	}

	// getters and setters
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

}
