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
	
	public String getName() {
		return name;
	}

	public int getBankroll() {
		return bankroll;
	}

	public void placeBet(int amtBet) {
		if (amtBet < bankroll) {
			bet = amtBet;
		} else {
			System.out.println("Not enough left to bet that high.");
		}
	}
	
	public int getBet() {
		return bet;
	}

	public void collectWinnings(int winnings) {
		bankroll = bankroll + winnings;
		bet = 0;
	}

	public void betLost(int loss) {
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
