package edu.avale1648.internationale.sql.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.avale1648.internationale.sql.models.Post;
import edu.avale1648.internationale.sql.models.Union;
import edu.avale1648.internationale.sql.models.User;

public class HibernateSessionFactoryUtil {
	private static SessionFactory factory;

	private HibernateSessionFactoryUtil() {

	}

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			try {
				var config = new Configuration().configure();

				config.addAnnotatedClass(Post.class);
				config.addAnnotatedClass(User.class);
				config.addAnnotatedClass(Union.class);

				var builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

				factory = config.buildSessionFactory(builder.build());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return factory;
	}
}
