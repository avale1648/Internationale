package edu.avale1648.internationale.util.role;

public class IllegalRoleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalRoleException(String errorMessage) {
		super(errorMessage);
	}
	public IllegalRoleException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}
}
