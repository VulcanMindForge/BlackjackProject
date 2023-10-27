package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck {
  private List<PlayingCard> cards;

  public PlayingCardDeck() {
    cards = createDeck();
  }
  
  private List<PlayingCard> createDeck(){
    List<PlayingCard> deck = new ArrayList<>(52);
    for(PlayingCardSuit s : PlayingCardSuit.values()) {
      for(PlayingCardRank r : PlayingCardRank.values()) {
        deck.add(new PlayingCard(r, s));
      }
    }
    return deck;
  }
  
  public int checkDeckSize() {
    return cards.size();
  }
  
  public void shuffle() {
    Collections.shuffle(cards);
  }
  
  public PlayingCard dealCard() {
    return cards.remove(0);
  }
  
}
