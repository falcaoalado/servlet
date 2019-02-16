package br.com.falcaoalado.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	void open() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SERVLET?useSSL=false", "root", "1234");
	}

	void close() throws Exception {
		this.connection.close();
	}

}
