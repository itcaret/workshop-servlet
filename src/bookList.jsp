<%@page import="javax.crypto.SealedObject"%>
<%@page import="java.util.List"%>
<%@page import="example.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Book> searchedBookList = (List<Book>) request.getAttribute("searchedBookList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
	<h1>Book List</h1>
	<table border="1">
		<%
			for (Book book : searchedBookList) {
		%>
		<tr>
			<td><%=book.getId()%></td>
			<td><%=book.getTitle()%></td>
			<td><%=book.getPrice()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
