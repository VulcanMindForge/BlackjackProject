/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

public abstract class CardPlayer {
	private String name;
	private int bankroll;
	private int bet;

	public CardPlayer(String name, int bankroll) {
		this.name = name;
		this.bankroll = bankroll;
	}

	public int placeBet(int amtBet) {
		bet = amtBet;
		return amtBet;
	}

	public void collectWinnings(int amtFromPot) {
		bankroll = bankroll + amtFromPot;
	}

	public void betLost() {
		bankroll = bankroll - bet;
		bet = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardPlayer [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		builder.append("bankroll=");
		builder.append(bankroll);
		builder.append("]");
		return builder.toString();
	}

}
