package edu.avale1648.internationale.sql.dao;

import edu.avale1648.internationale.sql.models.User;

public class UserDao extends AbstractHibernateDao<User>{
	public UserDao() {
		super(User.class);
	}
}
