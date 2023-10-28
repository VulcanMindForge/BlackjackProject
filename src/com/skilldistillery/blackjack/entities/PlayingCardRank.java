package com.skilldistillery.blackjack.entities;

public enum PlayingCardRank {

    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), 
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
    JACK(10), QUEEN(10), KING(10), ACE(11);
    
    private int value;
    
    private PlayingCardRank(int value) {
    	this.value = value;
    }

    public int getValue() {
      return value;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	if(this.name().equals("ACE") || this.name().equals("KING") || this.name().equals("QUEEN") || this.name().equals("JACK")) {
    		sb.append(this.name().charAt(0));
    		sb.append(this.name().substring(1).toLowerCase());
    	} else {
    		sb.append(this.getValue());
    	}
    	return sb.toString();
    }
}