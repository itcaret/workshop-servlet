package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist2")
public class BookListServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookTitle = req.getParameter("bookTitle");
		if (bookTitle == null || bookTitle.equals("")) {
			bookTitle = "";
		}
		
		List<String> bookList = Arrays.asList("Java Book", "HTML Book", "JavaScript Book");
		
		List<String> searchedBookList = new ArrayList<>();
		for (String book : bookList) {
			if (book.startsWith(bookTitle)) {
				searchedBookList.add(book);
			}
		}
		
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book List2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Book List2</h1>");
		out.println("<ul>");
		for (String book : searchedBookList) {
			out.println("<li>" + book + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
