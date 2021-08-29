package pl.michalzadrozny.core.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
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
@SessionScoped
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

	public String deleteBook(Book book) {
		log.info("deleteBook: {}", book);

		bookService.deleteBook(book);

		return "index";
	}
}
