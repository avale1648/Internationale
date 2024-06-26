package edu.avale1648.internationale.sql.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
	private static SessionFactory factory;

	private HibernateSessionFactoryUtil() {

	}

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			try {
				var config = new Configuration();
				config.configure("hibernate.cfg.xml");
				var builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

				factory = config.buildSessionFactory(builder.build());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return factory;
	}
}
