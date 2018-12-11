package example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booklist6")
public class BookListServlet6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookTitle = req.getParameter("bookTitle");
		if (bookTitle == null || bookTitle.equals("")) {
			bookTitle = "";
		}
		
		List<Book> searchedBookList = BookDAO.findByTitle(bookTitle);
		
		req.setAttribute("searchedBookList", searchedBookList);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bookList.jsp");
		rd.forward(req, resp);
	}

}
