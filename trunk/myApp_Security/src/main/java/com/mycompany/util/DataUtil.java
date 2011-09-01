package com.mycompany.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
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

	private BasicDataSource dataSource;

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
		Connection jdbcConnection = dataSource.getConnection();
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		return connection;
	}
	
	

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
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
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	

}
