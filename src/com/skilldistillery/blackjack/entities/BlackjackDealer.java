/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackDealer extends CardPlayer {
	private PlayingCardDeck deck;
	private BlackjackHand dealerHand;
	private boolean isDealerTurn = false;

	public BlackjackDealer(String name, int bankroll) {
		super(name, bankroll);
		deck = new PlayingCardDeck();
		dealerHand = new BlackjackHand();
		deck.shuffleThouroughly();
	}

	public void shuffleAtPenetration() {
		if ((deck.initialDeckSize() * .33) > deck.remainingDeckSize()) {
			System.out.println("Shuffling full deck.");
			deck = new PlayingCardDeck();
			deck.shuffleThouroughly();
		}
	}

	public void dealCards(List<BlackjackPlayer> players) {
		for (int i = 0; i < 2; i++) {
			dealPlayerCard(players);
			dealDealerCard();
		}
	}

	public void dealDealerCard() {
		deck.dealCardToHand(dealerHand);
		displayDealerHand();
	}

	public void dealPlayerCard(List<BlackjackPlayer> players) {
		for (BlackjackPlayer blackjackPlayer : players) {
			deck.dealCardToHand(blackjackPlayer.getPlayerHand());
			blackjackPlayer.displayPlayerHand();
		}
	}

	public void displayDealerHand() {
		System.out.println("Dealer has: ");
		if (isDealerTurn) {
			System.out.println(dealerHand.toString());
			System.out.println(dealerHand.getHandValue());
		} else {
			System.out.println("Face Down Card");
			if (dealerHand.hand.size() == 2) {
				System.out.println(dealerHand.hand.get(1));
			}
		}
		System.out.println();
	}

	public boolean checkForBlackjack(List<BlackjackPlayer> players) {
		boolean isBlackjack = false;
		for (BlackjackPlayer blackjackPlayer : players) {
			if (blackjackPlayer.checkBlackJack()) {
				return true;
			}
		}
		isBlackjack = dealerHand.isBlackjack();
		return isBlackjack;
	}
	
	public PlayingCard dealSingleCard() {
		return deck.dealCard();
	}

	public void dealerTurn() {
		isDealerTurn = true;
		displayDealerHand();

		while (dealerHand.getHandValue() < 17) {
			System.out.println("Dealer must hit.");
			deck.dealCardToHand(dealerHand);
			displayDealerHand();
		}
		isDealerTurn = false;
	}

	public void checkWinners(List<BlackjackPlayer> players) {
		for (BlackjackPlayer blackjackPlayer : players) {
			if (blackjackPlayer.checkBlackJack()) {
				if (dealerHand.isBlackjack()) {
					System.out.println("Blackjack push, no winner.");
					pushWin(blackjackPlayer);
				} else {
					System.out.println(blackjackPlayer.getName() + " wins with a BLACKJACK!");
					blackjackPlayer.collectWinnings(blackjackPlayer.getBet() * 3);
				}
			} else if (dealerHand.isBlackjack()) {
				System.out.println("Dealer has a Blackjack and no players have Blackjack, dealer wins.");
				dealerWin(blackjackPlayer);
			} else if (blackjackPlayer.checkBust()) {
				System.out.println("Player busts, dealer wins.");
				dealerWin(blackjackPlayer);
			} else if (!blackjackPlayer.checkBust() && dealerHand.isBust()) {
				System.out.println("Dealer bust, " + blackjackPlayer.getName() + " wins.");
				playerWin(blackjackPlayer);
			} else {
				if (dealerHand.getHandValue() > blackjackPlayer.getPlayerHand().getHandValue()) {
					System.out.println("Dealer has high hand, dealer wins.");
					dealerWin(blackjackPlayer);
				} else if (dealerHand.getHandValue() == blackjackPlayer.getPlayerHand().getHandValue()) {
					System.out.println("Push, no winner.");
					pushWin(blackjackPlayer);
				} else {
					System.out.println(blackjackPlayer.getName() + " wins with the higher hand.");
					playerWin(blackjackPlayer);
				}
			}
		}
	}

	public void dealerWin(BlackjackPlayer player) {
		System.out.println(player.getName() + " lost $" + player.getBet());
		player.collectWinnings(getBet());
	}

	public void playerWin(BlackjackPlayer player) {
		int winnings = player.getBet() * 2;
		System.out.println(player.getName() + " won $" + winnings);
		player.collectWinnings(winnings);
	}

	public void pushWin(BlackjackPlayer player) {
		System.out.println(player.getName() + " broke even.");
		player.collectWinnings(player.getBet());
	}

	public void clearPlayedCards(List<BlackjackPlayer> players) {
		for (BlackjackPlayer blackjackPlayer : players) {
			blackjackPlayer.clearHand();
		}
		dealerHand.clear();
	}

}
