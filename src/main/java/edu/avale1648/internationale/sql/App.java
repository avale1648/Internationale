package edu.avale1648.internationale.sql;

import java.sql.SQLException;
import java.time.LocalDateTime;

import edu.avale1648.internationale.sql.models.Post;
import edu.avale1648.internationale.sql.models.Union;
import edu.avale1648.internationale.sql.models.User;
import edu.avale1648.internationale.sql.services.PostService;
import edu.avale1648.internationale.sql.services.UnionService;
import edu.avale1648.internationale.sql.services.UserService;

public class App {
	public static void main(String[] args) throws SQLException {
		var userService = new UserService();
		var avale1648 = new User("avale1648", "avale1648@gmail.com", "8461elava", LocalDateTime.of(2001, 1, 22, 0, 0, 0));
		userService.save(avale1648);
		
		var unionService = new UnionService();
		var rkfsr = new Union("RKFSR", avale1648, false);
		unionService.save(rkfsr);
		
		var postService = new PostService();
		var post = new Post(avale1648, rkfsr, "First post");
		postService.save(post);
	}
}
