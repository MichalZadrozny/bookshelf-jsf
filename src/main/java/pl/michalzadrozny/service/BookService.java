package pl.michalzadrozny.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.entity.Book;

@ManagedBean
@SessionScoped
public class BookService {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);
	public List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		log.info("Request to getBooks");

		return books;
	}

	public void addBook(Book book) {
		log.info("Request to addBook : {}", book);

		books.add(book);
	}

	public Book getSingleBook(int id) {
		log.info("Request to getSingleBook : {}", id);

		return books.get(id);
	}
}
