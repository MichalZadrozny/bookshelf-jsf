package pl.michalzadrozny.core.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

@Named
@RequestScoped
public class BookController extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = -2108176301178285795L;
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	public String showBook(Book book) {

		log.info("showBook: {}", book);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("showBook", book);

		return "book";
	}

	public String addBook(Book book) {

		log.info("addBook: {}", book);

		bookService.addBook(book);

		return "index";
	}

	public String deleteBook(Book book) {
		log.info("deleteBook: {}", book);

		bookService.deleteBook(book);

		return "index";
	}

	public String updateBook(Book book) {

		log.info("updateBook: {}", book);

		bookService.updateBook(book);

		return "index";
	}

	public String showUpdateBook(Book book) {

		log.info("showUpdateBook: {}", book);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		book.setAuthor(null);
		requestMap.put("book", book);

		return "edit-book";
	}
}
