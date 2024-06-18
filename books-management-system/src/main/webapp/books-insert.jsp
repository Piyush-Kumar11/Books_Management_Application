<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Registration Form</title>
</head>
<body>
  <div style="text-align: center; margin: 20px auto; border: 1px solid #ddd; padding: 20px; border-radius: 5px;">
    <h3>Register a New Book</h3>
    <form action="booksRegister" style="margin: 0 auto; width: 50%;">
      <label for="book_id">Book ID:<span class="required">*</span></label>
      <input type="number" id="book_id" name="id" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; margin-bottom: 15px;">
      <label for="book_title">Title:<span class="required">*</span></label>
      <input type="text" id="book_title" name="title" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; margin-bottom: 15px;">
      <label for="book_author">Author:<span class="required">*</span></label>
      <input type="text" id="book_author" name="author" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; margin-bottom: 15px;">
      <label for="book_price">Price:<span class="required">*</span></label>
      <input type="number" id="book_price" name="price" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; margin-bottom: 15px;">
      <input type="submit" value="Add Books" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px;">
    </form>
  </div>
</body>
</html>
