package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist5")
public class BookListServlet5 extends HttpServlet {

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
		
		req.setAttribute("searchedBookList", searchedBookList);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bookList.jsp");
		rd.forward(req, resp);
	}
}
