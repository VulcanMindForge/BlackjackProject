package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck {
	private List<PlayingCard> deck = new ArrayList<>();
	private final int initialDeckSize;

	public PlayingCardDeck() {
		PlayingCardSuit[] allSuits = PlayingCardSuit.values();
		PlayingCardRank[] allRanks = PlayingCardRank.values();

		for (PlayingCardSuit suit : allSuits) {
			for (PlayingCardRank rank : allRanks) {
				deck.add(new PlayingCard(rank, suit));
			}
		}
		initialDeckSize = allSuits.length * allRanks.length;
	}

	public int initialDeckSize() {
		return initialDeckSize;
	}
	
	public int remainingDeckSize() {
		return deck.size();
	}

	public PlayingCard dealCard() {
		return deck.remove(remainingDeckSize() - 1);
	}
	
	public void dealCardToHand(PlayingCardHand hand) {
		hand.addCard(dealCard());
	}

	public void shuffleThouroughly() {
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(deck);
		}
	}

}
