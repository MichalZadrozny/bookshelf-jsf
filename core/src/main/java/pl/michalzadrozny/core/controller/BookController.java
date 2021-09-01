package pl.michalzadrozny.core.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

@Named
@RequestScoped
public class BookController implements Serializable {

	private static final long serialVersionUID = -2108176301178285795L;
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Inject
	private BookService bookService;

	public String addBook(Book book) {

		log.info("addBook: {}", book);

		bookService.addBook(book);

		return "index?faces-redirect=true";
	}

	public String deleteBook(Book book) {

		log.info("deleteBook: {}", book);

		bookService.deleteBook(book);

		return "index?faces-redirect=true";
	}

	public String updateBook(Book book) {

		log.info("updateBook: {}", book);

		bookService.updateBook(book);

		return "index?faces-redirect=true";
	}
}
