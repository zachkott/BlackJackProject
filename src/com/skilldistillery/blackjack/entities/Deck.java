package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOCards = new ArrayList<>();;

	public Deck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deckOCards.add(new Card(s, r));
			}
		}

	}

	public int checkDeckSize() {

		return deckOCards.size();

	}

	public Card dealCard() {
		Card aCard = deckOCards.remove(0);
		return aCard;
	}

	public void shuffle() {
		Collections.shuffle(deckOCards);
	}

}
