package com.jsp.books_management_system.controller;

import java.io.IOException;

import com.jsp.books_management_system.dao.BooksDao;
import com.jsp.books_management_system.dto.Books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/booksUpdate")
public class BooksUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BooksDao dao = new BooksDao();

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));

		// The product object will set the values inside database
		Books book = new Books(id, title, author, price);
		dao.updateBooksDetailsDao(book);
		req.getRequestDispatcher("books-display.jsp").forward(req, resp);

	}
}
