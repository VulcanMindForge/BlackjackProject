/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayingCardHand {
protected List<PlayingCard> hand = new ArrayList<>();

public PlayingCardHand(){};
 
public void addCard (PlayingCard card) {
	hand.add(card);
}

public void clear() {
	hand.clear();
}

public abstract int getHandValue();

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("PlayingCardHand [");
	if (hand != null) {
		builder.append("hand=");
		builder.append(hand);
	}
	builder.append("]");
	return builder.toString();
}

}
