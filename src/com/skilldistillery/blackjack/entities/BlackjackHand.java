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
		if (isAce() && getHandValue() == maxHandValue && hand.size() == 2) {
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

	public boolean isAce() {
		boolean isAce = false;
		for (PlayingCard playingCard : hand) {
			if (playingCard.getValue() == 11) {
				isAce = true;
			}
		}
		return isAce;
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (PlayingCard playingCard : hand) {
			handValue = handValue + playingCard.getValue();	
		}
		if (handValue > maxHandValue) {
			if (isAce()) {
				handValue = handValue - 10;
			}
		}
		return handValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (PlayingCard playingCard : hand) {
			builder.append(playingCard.toString() + "\n");
		}
		return builder.toString();
	}

}
