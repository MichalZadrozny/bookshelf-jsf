package pl.michalzadrozny.core.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.core.entity.Book;

@Named
@SessionScoped
public class BookController implements Serializable {

	private static final long serialVersionUID = -2108176301178285795L;
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	public String showBook(Book book) {

		log.info("showBook: {}", book);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("showBook", book);

		return "book";
	}
}
