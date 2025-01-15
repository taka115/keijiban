package dao;

import javax.sql.DataSource;

public class KeijibanDaoImpl implements KeijibanDao {
	
	DataSource ds;
	
	public KeijibanDaoImpl(DataSource ds) {
		this.ds = ds;
	}

}
