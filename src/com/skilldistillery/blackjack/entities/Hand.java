package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	// Every hand will have a list of 52 cards
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();

	}

	
	public void addCard(Card card) {
		cards.add(card);
	}

	public void clear() {
		cards.removeAll(cards);

	}
	

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(cards);
		return sb.toString();
	}

}
