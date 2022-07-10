package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOCards;

	public Deck() {
		deckOCards = newDeck();

	}

	public List<Card> newDeck() {
		deckOCards = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deckOCards.add(new Card(s, r));
			}
		}
		return deckOCards;
	}

	public int checkDeckSize() {

		return deckOCards.size();

	}

	public Card dealCard() {

		if (deckOCards.size() == 0) {
			newDeck();
			shuffle();
		}

		Card aCard = deckOCards.remove(0);
		return aCard;
	}

	public List<Card> dealCards(int howMany, List<Card> d) {

		for (int i = 0; i < howMany; i++) {
			if (deckOCards.size() != 0) {
				d.add(dealCard());
			}
		}
		return d;
	}

	public void shuffle() {
		Collections.shuffle(deckOCards);
	}

	@Override
	public String toString() {
		return "Deck [deckOCards=" + deckOCards + "]";
	}

}
