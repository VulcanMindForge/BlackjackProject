/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;
import com.skilldistillery.blackjack.entities.CardPlayer;

public class BlackjackApp {
	private List<BlackjackPlayer> allPlayers = new ArrayList<>();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	private void run() {
		BlackjackPlayer player1 = new BlackjackPlayer("Jacob", 1000);
		BlackjackDealer dealer = new BlackjackDealer("Frank", 10000);

		allPlayers.add(player1);

		greeting();

		while (!isPlayer()) {
			System.out.println("Place your bets.");
			playersPlaceBets();
			dealer.dealCards(allPlayers);
			if (!dealer.checkForBlackjack(allPlayers)) {
				playerTurns(dealer);
				dealer.dealerTurn();
			}
			dealer.checkWinners(allPlayers);
			dealer.clearPlayedCards(allPlayers);
			dealer.shuffleAtPenetration();
			keepPlaying();
		}

		farewell();
	}

	private void playersPlaceBets() {
		for (CardPlayer cardPlayer : allPlayers) {
			System.out.print("How much would you like to bet?\n$>");
			int betAmt = 0;
			try {
				betAmt = kb.nextInt();
				kb.nextLine();
			} catch (Exception e) {
				System.err.println("I am sorry, that is not a valid number.");
			}
			cardPlayer.placeBet(betAmt);
		}
	}

	private void playerTurns(BlackjackDealer dealer) {
		for (BlackjackPlayer blackjackPlayer : allPlayers) {
			dealer.displayDealerHand();
			System.out.println();
			String playerMove = "";
			while (!blackjackPlayer.checkBust() && !blackjackPlayer.playerStands(playerMove)) {
				blackjackPlayer.displayPlayerHand();
				System.out.println("Current hand value is " + blackjackPlayer.getPlayerHand().getHandValue());
				System.out.println("Would you like to hit or stand?");
				try {
					playerMove = kb.nextLine();
					playerMove = playerMove.toUpperCase();
					if (playerMove.equals("HIT")) {
						blackjackPlayer.playerHits(dealer.dealSingleCard());
					} else if (playerMove.equals("STAND")) {
						blackjackPlayer.playerStands(playerMove);
					} else {
						System.err.println("I'm sorry, that is not a valid choice.");
					}
				} catch (NoSuchElementException e) {
					System.err.println(e.getMessage());
				}
				if (blackjackPlayer.checkBust()) {
					System.out.println("Player busts.");
				}
			}
		}
	}

	private void keepPlaying() {
		System.out.print("Type yes if you would like to keep playing?\n$>");
		for (BlackjackPlayer blackjackPlayer : allPlayers) {
			boolean validEntry = false;
			while (!validEntry) {
				String playerChoice = kb.nextLine().toUpperCase();
				if (playerChoice.equals("YES") || playerChoice.equals("NO")) {
					blackjackPlayer.playerCashOut(playerChoice);
					validEntry = true;
				} else {
					System.err.println("That is not a valid entry, please choose Yes or No");
				}
			}
		}
	}

	private boolean isPlayer() {
		boolean playerAtTable = true;
		for (BlackjackPlayer blackjackPlayer : allPlayers) {
			playerAtTable = blackjackPlayer.playerCashOut("");
		}
		return playerAtTable;
	}

	private void greeting() {
		System.out.println("Hello");
	}

	private void farewell() {
		System.out.println("Thank you for playing!");
	}
}
