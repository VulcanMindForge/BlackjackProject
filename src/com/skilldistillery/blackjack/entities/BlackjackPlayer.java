/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

public class BlackjackPlayer extends CardPlayer {
protected BlackjackHand playerHand;

public BlackjackPlayer (String name, int bankroll) {
	super(name, bankroll);
	playerHand = new BlackjackHand();
}

public void playerHits (PlayingCard card) {
	playerHand.addCard(card);
}

public boolean playerStands() {
	boolean playerStands = true;
	return playerStands;
}

public boolean playerCashOut() {
	boolean cashOut = true;
	return cashOut;
}

}
