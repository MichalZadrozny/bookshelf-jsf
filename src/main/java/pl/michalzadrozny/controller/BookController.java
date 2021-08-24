package pl.michalzadrozny.controller;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.entity.Book;

@ManagedBean
@SessionScoped
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	public String showBook(Book book) {

		log.info("updateBook: {}", book);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("book", book);

		return "book";
	}
}
