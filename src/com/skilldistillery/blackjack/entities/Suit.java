package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	

	Suit(String name) {
		this.name = name;
	}

	final private String name;

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}
}
