package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	public static List<Book> findByTitle(String bookTitle) throws IOException {
		
		List<Book> bookList = BookDAO.findAll();
		
		List<Book> searchedBookList = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getTitle().startsWith(bookTitle)) {
				searchedBookList.add(book);
			}
		}
		return searchedBookList;
	}

	public static List<Book> findAll() throws IOException {
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
		return bookList;
	}

}
