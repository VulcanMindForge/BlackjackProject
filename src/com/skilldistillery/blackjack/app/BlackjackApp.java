/*
Synopsis:
Author:
Version: 
 */
package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;
import com.skilldistillery.blackjack.entities.CardPlayer;

public class BlackjackApp {
private List<BlackjackPlayer> allPlayers = new ArrayList<>();
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}
	
	private void run(){
	BlackjackPlayer player1 = new BlackjackPlayer("Jacob", 1000);
	BlackjackDealer dealer = new BlackjackDealer("Frank", 10000);
	
	allPlayers.add(player1);
	
	System.out.println("Beginning game!");
	System.out.println("Place your bets.");
	takeBets();
	dealer.dealCards(allPlayers);
	
	}
	
	private void takeBets() {
		for (CardPlayer cardPlayer : allPlayers) {
			cardPlayer.placeBet(10);
		}
	}
	
	private void checkForBlackjacks() {
		for (BlackjackPlayer blackjackPlayer : allPlayers) {
		}
	}
		//Loop until player leaves
//D	Deal cards, Dealer[0] facedown	Deal phase
//D	Check Players/Dealer for Blackjack	Blackjack payout/peek
//P	Hit/Stand per Player choice	Player turns
//D	Hit/Stand per logic	Dealer turn
//D	Winner logic	Winner decided
//P		Bet payouts
//D		Check for fullShuffle
//D		Clear cards and re-deal

}
