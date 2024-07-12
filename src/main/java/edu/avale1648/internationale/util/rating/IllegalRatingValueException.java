package edu.avale1648.internationale.util.rating;

public class IllegalRatingValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalRatingValueException(String errorMessage) {
		super(errorMessage);
	}
	public IllegalRatingValueException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}
}
