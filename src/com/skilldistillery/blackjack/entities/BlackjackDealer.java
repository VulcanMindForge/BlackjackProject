/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackDealer extends CardPlayer {
	public PlayingCardDeck deck;
	private BlackjackHand dealerHand;

	public BlackjackDealer(String name, int bankroll) {
		super(name, bankroll);
		deck = new PlayingCardDeck();
		dealerHand = new BlackjackHand();
		deck.shuffleThouroughly();
	}

	public void shuffleAtPenetration() {
		if ((deck.initialDeckSize() * .33) < deck.remainingDeckSize()) {
			deck = new PlayingCardDeck();
			deck.shuffleThouroughly();
		}
	}

	public void dealCards(List<BlackjackPlayer> players) {
		for (int i = 0; i < 2; i++) {

			for (BlackjackPlayer blackjackPlayer : players) {
				deck.dealCardToHand(blackjackPlayer.playerHand);
			}
			dealDealerCard();
		}
	}

	public void dealDealerCard() {
		deck.dealCardToHand(dealerHand);
	}
	
	public void dealerHand() {
		System.out.println(dealerHand.hand.get(1));
	}
	

	public void dealerTurn() {
		while (dealerHand.getHandValue() < 18) {
			deck.dealCardToHand(dealerHand);
		}
		
		if (dealerHand.isBlackjack()) {
			System.out.println("Dealer has 21");
		} else if (dealerHand.isBust()) {
			System.out.println("Dealer busts.");
		}
	}

	public void clearPlayedCards() {

	}

}
