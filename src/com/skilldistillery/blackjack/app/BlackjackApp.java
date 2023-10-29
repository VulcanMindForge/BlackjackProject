/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;
import com.skilldistillery.blackjack.entities.CardPlayer;

public class BlackjackApp {
	private List<BlackjackPlayer> allPlayers;
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	private void run() {
		String fileName = "players.txt";
		BlackjackDealer dealer = addDealer();
		allPlayers = getPlayers(fileName);


		greeting();

		while (isPlayer()) {
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
	
	private BlackjackDealer addDealer() {
		BlackjackDealer dealer = new BlackjackDealer("Frank", 1000);
		return dealer;
	}
	
	private List<BlackjackPlayer> getPlayers(String fileName) {
		allPlayers = new ArrayList<BlackjackPlayer>();
		
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] player = line.split(", ");
				String name = player[0];
				int bank = Integer.parseInt(player[1]);
				BlackjackPlayer newPlayer = new BlackjackPlayer(name, bank);
				allPlayers.add(newPlayer);
			}
		} catch (FileNotFoundException notFound) {
			System.err.println("");
		} catch (IOException e) {
			System.err.println("Error reading from " + fileName + ": " + e.getMessage());
		}
		
		if (allPlayers.size() == 0) {
			BlackjackPlayer player1 = new BlackjackPlayer("Jacob", 1000);
			allPlayers.add(player1);
		}
		
		return allPlayers;	
	}
	
	private void playersPlaceBets() {
		for (CardPlayer cardPlayer : allPlayers) {
			System.out.print(cardPlayer.getName() + " how much would you like to bet?\n$>");
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
		boolean validEntry = false;
		boolean playerLeaving = false;
		for (int player = 0; player < allPlayers.size(); player++) {
			while (!validEntry) {
				System.out.print(allPlayers.get(player).getName() + " type yes if you would like to keep playing?\n$>");
				String playerChoice = kb.nextLine().toUpperCase();
				if (playerChoice.equals("YES") || playerChoice.equals("NO")) {
					playerLeaving = allPlayers.get(player).playerCashOut(playerChoice);
					validEntry = true;
				} else {
					System.err.println("That is not a valid entry, please choose Yes or No");
				}
			}
			if (playerLeaving == true) {
				allPlayers.remove(allPlayers.get(player));
			}
		}
	}

	private boolean isPlayer() {
		boolean playerAtTable = true;
		if (allPlayers.size() == 0) {
			playerAtTable = false;
		}
		return playerAtTable;
	}

	private void greeting() {
		System.out.println("Hello\n");
		System.out.println("Please welcome our player" + (allPlayers.size() == 1 ? "." : "s."));
		for (BlackjackPlayer blackjackPlayer : allPlayers) {
			System.out.println(blackjackPlayer.getName());
		}
		System.out.println();
	}

	private void farewell() {
		System.out.println("\nThank you for playing!\n");
	}
}
