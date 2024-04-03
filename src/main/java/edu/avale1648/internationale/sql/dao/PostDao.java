package edu.avale1648.internationale.sql.dao;

import edu.avale1648.internationale.sql.models.Post;

public class PostDao extends AbstractHibernateDao<Post> {
	public PostDao() {
		super(Post.class);
	}
}
