<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jsp.books_management_system.dao.BooksDao"%>
<%@ page import="com.jsp.books_management_system.dto.Books"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Display</title>
<style>
  table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
    background-color: #f1f1f1;
  }
  button {
    padding: 15px 30px;  /* Increase padding for larger button */
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    font-size: 18px;  /* Increase font size for larger button text */
  }
  button:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
  <h1>Books Management System</h1>

  <%
  BooksDao dao = new BooksDao();
  List<Books> books = dao.displayAllBooksDao(); //Import this method to display the user details
  %>

  <table>
    <thead>
      <tr>
        <th>Book Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th colspan="2">Action:</th>
      </tr>
    </thead>
    <tbody>
      <%
      for (Books book : books) {
      %>
      <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getAuthor()%></td>
        <td><%=book.getPrice()%></td>
        <td><a href="delete?id=<%=book.getId()%>"><button>Delete</button></a></td>
        <td><a href="books-update.jsp?id=<%=book.getId()%>"><button>Edit</button></a></td>
      </tr>
      <%
      }
      %>
    </tbody>
  </table>

  <a href="books-insert.jsp"><button>Add Books</button></a>  </body>
</html>