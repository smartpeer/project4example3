package com.mycompany.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class DataUtil {

	private SessionFactory sessionFactory;

	private Resource dataSetResource;

	private boolean populate = false;

	public DataUtil() {
		super();

	}

	@SuppressWarnings("deprecation")
	private IDataSet getDataSet() throws Exception {
		InputStream inputStream = dataSetResource.getInputStream();
		IDataSet dataset = new FlatXmlDataSet(inputStream);
		return dataset;
	}

	private IDatabaseConnection getConnection() throws Exception {
		Connection jdbcConnection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		return connection;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Resource getDataSetResource() {
		return dataSetResource;
	}

	public void setDataSetResource(Resource dataSetResource) {
		this.dataSetResource = dataSetResource;
	}

	public boolean isPopulate() {
		return populate;
	}

	public void setPopulate(boolean populate) {

		if (populate) {
			this.populate = populate;
			try {
				DatabaseOperation.CLEAN_INSERT.execute(getConnection(),
						getDataSet());
			} catch (DatabaseUnitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
