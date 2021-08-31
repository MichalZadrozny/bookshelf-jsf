package pl.michalzadrozny.core.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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

	public void showBook(Book book) {

		log.info("showBook: {}", book);

		String url = "book.xhtml?id=" + book.getId();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			log.info(e.getMessage());
		}

	}

	public void getBook(Long id) {

		log.info("getBook: {}", id);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("book", bookService.getSingleBook(id));
	}

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

	public void showUpdateBook(Book book) {

		log.info("showUpdateBook: {}", book);

		String url = "edit-book.xhtml?id=" + book.getId();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}
}
