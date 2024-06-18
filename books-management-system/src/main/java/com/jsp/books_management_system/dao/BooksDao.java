package com.jsp.books_management_system.dao;
/*
 * @Piyush
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.books_management_system.connection.BooksConnection;
import com.jsp.books_management_system.dto.Books;

public class BooksDao {

	private final String insert_book_query = "INSERT INTO books_management_system(id,title,author,price) VALUES(?,?,?,?)";
	private final String delete_book_by_id = "DELETE FROM books_management_system WHERE id = ?";
	private final String display_book_by_id = "SELECT * FROM books_management_system WHERE id = ?";
	private final String display_book = "SELECT *  FROM books_management_system";
	private final String update_book = "UPDATE  books_management_system SET title =?,author=?,price=? WHERE id=?";

	Connection connection = BooksConnection.getBooksConnection();

	PreparedStatement ps;

	public Books saveBooksDao(Books book) {

		try {
			ps = connection.prepareStatement(insert_book_query);

			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.execute();
			return book;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteBooksById(int id) {
		try {
			ps = connection.prepareStatement(delete_book_by_id);
			ps.setInt(1, id);

			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	public Books getBooksById(int id) {
		try {
			ps = connection.prepareStatement(display_book_by_id);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				int Id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");

				return new Books(Id, title, author, price);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Books> displayAllBooksDao() {
		try {
			ps = connection.prepareStatement(display_book);
			ResultSet resultSet = ps.executeQuery();

			List<Books> books = new ArrayList<Books>(); 

			while (resultSet.next()) {
				int Id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				Books book = new Books(Id, title, author, price);

				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateBooksDetailsDao(Books book) {
		try {
			ps = connection.prepareStatement(update_book);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}