package edu.avale1648.internationale.util;

public final class Role {
	//ordinary user
	public static final String USER = "user";
	//admin can delete posts 
	public static final String ADMIN = "admin";
	public static final String MAIN_ADMIN = "main_admin";
	
	public static final boolean isValid(String role) {
		return role == USER || role == ADMIN || role == MAIN_ADMIN;
	}
}
