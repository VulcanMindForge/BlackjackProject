/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends PlayingCardHand {
	private int maxHandValue = 21;

	public BlackjackHand() {
		super();
	}
	
	public boolean isBlackjack() {
		boolean blackjack = false;
		if (isHard() && getHandValue() == maxHandValue && hand.get(1).getValue() == 11) {
			blackjack = true;
		} 
		return blackjack;
	}
	
	public boolean isBust() {
		boolean bust = false;
		if (getHandValue() > maxHandValue) {
			bust = true;
		}
		return bust;
	}
	
	public boolean isHard() {
		boolean hardAce = true;
		for (PlayingCard playingCard : hand) {
			if (playingCard.getValue() == 11 && isBust()) {
				hardAce = false;
			}
		}
		return hardAce;
	}

	
	@Override
	public int getHandValue() {
		int handValue = 0;
		for (PlayingCard playingCard : hand) {
			handValue = handValue + playingCard.getValue();
		}
		return handValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (PlayingCard playingCard : hand) {
			builder.append(playingCard.toString());
		}
		return builder.toString();
	}
	
	
	
	

}
