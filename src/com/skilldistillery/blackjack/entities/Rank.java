package com.skilldistillery.blackjack.entities;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
	
	
	Rank(Integer val){
		this.value = val;
	}
	
	private final Integer value;
	
	
	public Integer getValue() {
		
		return value;
	}
	
	@Override
	public String toString() {
		return this.name().substring(0,1) + this.name().substring(1);
	}

	public Map<Rank, Integer> getValues(){
		Integer cardValue =  21;
		Map<Rank,Integer> cards = new HashMap<>();
		
		Rank [] rank = Rank.values();
		
		for (Rank r : rank) {
			Integer myCards = r.getValue() +  r.getValue();
			if(myCards == cardValue) {
				System.out.println("BlackJack!");
			} else {
				System.out.println(myCards);
			}
		}
		return cards;
	}
	
}
