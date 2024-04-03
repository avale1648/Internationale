package edu.avale1648.internationale.sql.services;

import edu.avale1648.internationale.sql.models.Post;
import edu.avale1648.internationale.sql.dao.PostDao;

public class PostService extends AbstractHibernateService<Post>{
	public PostService() {
		super(new PostDao());
	}
}
