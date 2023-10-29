/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;


public class BlackjackPlayer extends CardPlayer {
private BlackjackHand playerHand;

public BlackjackPlayer (String name, int bankroll) {
	super(name, bankroll);
	playerHand = new BlackjackHand();
}

public boolean checkBlackJack() {
	return playerHand.isBlackjack();
}

public boolean checkBust() {
	return playerHand.isBust();
}

public boolean checkAce() {
	return playerHand.isAce();
}

public int totalHandValue() {
	return playerHand.getHandValue();
}


public void clearHand() {
	playerHand.clear();
}

public BlackjackHand getPlayerHand() {
	return playerHand;
}

public void displayPlayerHand () {
	System.out.println(this.getName() + " has:");
	System.out.println(playerHand.toString());
}


public void playerHits (PlayingCard card) {
		playerHand.addCard(card);
}

public boolean playerStands(String stand) {
	boolean playerStands = false;
	if (stand.equals("STAND")) {
		playerStands = true;
	}
	return playerStands;
}

public boolean playerCashOut(String keepPlaying) {
	boolean cashOut = false;
	if (keepPlaying.equals("NO")) {
		cashOut = true;
	}
	return cashOut;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Player ");
	if (getName() != null) {
		builder.append(getName());
		builder.append(" is leaving with $");
	}
	builder.append(getBankroll());
	builder.append(" left.");
	return builder.toString();
}


}
