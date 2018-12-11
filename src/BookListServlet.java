package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> bookList = Arrays.asList("Java Book", "HTML Book", "JavaScript Book");

		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Book List</h1>");
		out.println("<ul>");
		for (String book : bookList) {
			out.println("<li>" + book + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
