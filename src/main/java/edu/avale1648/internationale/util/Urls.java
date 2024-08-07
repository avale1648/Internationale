package edu.avale1648.internationale.util;

public enum Urls {
	ORIGIN {
		public String toString() {
			return "http://localhost:3000";
		}
	},
	COMMUNITIES {
		public String toString() {
			return "/communities";
		}
	},
	MESSAGES {
		public String toString() {
			return "/messages";
		}
	},
	
	MODERATORS {
		public String toString() {
			return "/moderators";
		}
	},
	POSTS {
		public String toString() {
			return "/posts";
		}
	},
	RATINGS {
		public String toString() {
			return "/ratings";
		}
	},
	COMMUNITY_SUBSCRIPTIONS {
		public String toString() {
			return "/community_subscriptions";
		}
	},
	USER_SUBSCRIPTIONS {
		public String toString() {
			return "/user_subscriptions";
		}
	},
	USERS {
		public String toString() {
			return "/users";
		}
	}
}
