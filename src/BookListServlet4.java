package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist4")
public class BookListServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookTitle = req.getParameter("bookTitle");
		if (bookTitle == null || bookTitle.equals("")) {
			bookTitle = "";
		}
		
		List<Book> bookList = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("/Users/murayama/eclipse-workspace/exercise/book2.csv"));){
			String line = br.readLine();
			while(line != null) {
				String[] items = line.split(",");
				Integer id = Integer.parseInt(items[0]);
				String title = items[1];
				Integer price = Integer.parseInt(items[2]);
				Book book = new Book(id, title, price);
				bookList.add(book);
				line = br.readLine();
			}
		}

		List<Book> searchedBookList = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getTitle().startsWith(bookTitle)) {
				searchedBookList.add(book);
			}
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book List4</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Book List4</h1>");
		out.println("<table border=\"1\">");
		for (Book book : searchedBookList) {
			out.println("<tr>");
			out.println("<td>" + book.getId() + "</td>");
			out.println("<td>" + book.getTitle() + "</td>");
			out.println("<td>" + book.getPrice() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
