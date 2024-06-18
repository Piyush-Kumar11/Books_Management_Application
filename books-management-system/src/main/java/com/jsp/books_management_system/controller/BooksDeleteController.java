package com.jsp.books_management_system.controller;

import java.io.IOException;

import com.jsp.books_management_system.dao.BooksDao;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BooksDeleteController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id")); // To get the specific value from front-end to back-end
		new BooksDao().deleteBooksById(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("books-display.jsp");
		dispatcher.forward(req, res);

	}

}
