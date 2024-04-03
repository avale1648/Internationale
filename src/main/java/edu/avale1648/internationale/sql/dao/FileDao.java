package edu.avale1648.internationale.sql.dao;

import edu.avale1648.internationale.sql.models.File;

public class FileDao extends AbstractHibernateDao<File> {
	public FileDao() {
		super(File.class);
	}
}
