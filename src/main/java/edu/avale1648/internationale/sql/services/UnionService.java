package edu.avale1648.internationale.sql.services;

import edu.avale1648.internationale.sql.models.Union;
import edu.avale1648.internationale.sql.dao.UnionDao;

public class UnionService extends AbstractHibernateService<Union> {
	public UnionService() {
		super(new UnionDao());
	}
}
