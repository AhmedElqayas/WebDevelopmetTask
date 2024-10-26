package org.qayas.models;

import java.sql.*;

public class Repository {
	private static Connection connection = null;
	
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "0000");
	}
	
	private void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}
	
	public void saveUser(User user) throws SQLException, ClassNotFoundException {
			String query = "insert into users values (?,?,?,?,?);";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);
			
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			
			preparedStatement.execute();
			
			closeConnection();
	}
	

}
