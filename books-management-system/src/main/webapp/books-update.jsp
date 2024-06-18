<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jsp.books_management_system.dao.BooksDao"%>
<%@ page import="com.jsp.books_management_system.dto.Books"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Update Form</title>
<style>
  /* Styles for the update form container */
  .update-form {
    text-align: center;
    margin: 20px auto;
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 5px;
  }
  
  /* Styles for the update form */
  form {
    margin: 0 auto;
    width: 50%;
  }
  
  /* Styles for labels */
  label {
    display: block;
    margin-bottom: 5px;
  }
  
  /* Styles for input fields */
  input[type="text"], input[type="number"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    margin-bottom: 15px;
  }
  
  /* Styles for submit button */
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
  }
</style>
</head>
<body>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Books book = new BooksDao().getBooksById(id);
	%>

	<h2>Books Update Form</h2>

	<div>
		<!-- Update Form -->
		<form action="booksUpdate">
			<label>Book ID:<span class="required">*</span></label><br> <input type="number" id="book_id" name="id" value="<%=book.getId()%>"required><br>
				
			<br> <label>Book Title:<span class="required">*</span></label><br> <input type="text" id="book_title" name="title" value="<%=book.getTitle()%>" required><br>
			
			<br> <label>Author:<span class="required">*</span></label><br><input type="text" id="book_author" name="author" value="<%=book.getTitle()%>" required><br> 
				
			<br> <label>Price:<span class="required">*</span></label><br> <input type="number" id="book_price" name="price" value="<%=book.getPrice()%>" required><br>

			<br> <input type="submit" value="update">
		</form>
	</div>
</body>
</html>