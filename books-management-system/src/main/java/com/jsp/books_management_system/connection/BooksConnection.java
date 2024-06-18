package com.jsp.books_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BooksConnection {
	
	public static Connection getBooksConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet-a1", "root", "tiger");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
