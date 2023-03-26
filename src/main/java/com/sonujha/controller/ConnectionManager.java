package com.sonujha.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionManager {
	public static final String serverTimeZone = "UTC";
	public static final String serverName = "localhost";
	public static final String databaseName = "my_db";
	public static final int portNumber = 3306;
	public static final String user = "root";
	public static final String password = "Sonu123@";

	public static Connection getConnection() throws SQLException {

		MysqlDataSource dataSource = new MysqlDataSource();

		dataSource.setUseSSL(false);
		dataSource.setServerTimezone(serverTimeZone);
		dataSource.setServerName(serverName);
		dataSource.setDatabaseName(databaseName);
		dataSource.setPortNumber(portNumber);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setAllowPublicKeyRetrieval(true);

		return dataSource.getConnection();
	}
}
