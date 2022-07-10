package com.skilldistillery.blackjack.entities;

public class Dealer {

	// Every dealer will have a deck and black jack hand
	private Deck deck = new Deck();
	private BlackJackHand dealerHand = new BlackJackHand();

	public Dealer() {
		super();
	}

	// method that allows the dealer to shuffle the deck
	public void shuffleDeck() {
		deck.shuffle();
	}
	public Card  deal() {
		return deck.dealCard();
	}

	public BlackJackHand getHand() {
		return dealerHand;
	}
	public int handTotal() {
		return dealerHand.getHandValue();
	}

// got stuck on this for hours because i was coding in the wrong deck file... 
	public void dealCardPlayer(Guest player) {
		System.out.println(deck.dealCards(2, player.getHand().getCards()));

	}

	public void dealCardDealer() {
		System.out.println(deck.dealCards(1, dealerHand.getCards()));
	}

	public int cardsLeftInDeck() {
		return deck.checkDeckSize();
	}

	public void addCardToHand(Card card) {
		dealerHand.addCard(card);
	}
	
	public void hit(Guest player) {
	player.getHand().addCard(deck.dealCard());
	}
	
	public  void hit() {
		getHand().addCard(deck.dealCard());
	}
	public void stand(Dealer d) {
		d.showHand();
	}
	public void showHand() {
		int handValue = 0;
		System.out.println("Dealer's Hand: ");
		for (Card hand : dealerHand.cards) {
			System.out.println(hand);
			handValue += hand.getValue();

		}
		System.out.println("Hand value: " + handValue + "\n");
	}

}
