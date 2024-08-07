package edu.avale1648.internationale.util;

public final class RatingValue {
	public static final String RATING_UP = "rating_up";
	public static final String RATING_DOWN = "rating_down";
	
	public static final boolean isValid(String value) {
		if(value == RATING_UP || value == RATING_DOWN) {
			return true;
		} else {
			return false;
		}
		
	}
}
