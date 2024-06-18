package com.jsp.books_management_system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jsp.books_management_system.dao.BooksDao;
import com.jsp.books_management_system.dto.Books;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BooksInsertController implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BooksDao dao = new BooksDao();

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));

		// Create a new book object and save it using the DAO
		Books book = new Books(id, title, author, price);
		dao.saveBooksDao(book); // saveBooksDao() will save the book in the database.

		// Set a success message as a request attribute
		req.setAttribute("message", "Registered Successfully!");

		// Forward the request to the display page
		req.getRequestDispatcher("books-display.jsp").forward(req, res);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
