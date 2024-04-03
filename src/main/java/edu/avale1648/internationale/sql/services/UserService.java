package edu.avale1648.internationale.sql.services;

import edu.avale1648.internationale.sql.models.User;
import edu.avale1648.internationale.sql.dao.UserDao;

public class UserService extends AbstractHibernateService<User> {
	public UserService( ) {
		super(new UserDao());
	}
}
