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

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

@Named
@RequestScoped
public class AuthorController extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 994585156676448103L;
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	@Autowired
	private AuthorService authorService;

	public String showAuthor(Author author) {

		log.info("showAuthor: {}", author);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("showAuthor", author);

		return "author";
	}

	public String deleteAuthor(Author author) {

		log.info("deleteAuthor: {}", author);

		authorService.deleteAuthor(author);

		return "index";
	}

	public String updateAuthor(Author author) {

		log.info("updateAuthor: {}", author);

		authorService.updateAuthor(author);

		return "index";
	}

	public String showUpdateAuthor(Author author) {

		log.info("showUpdateAuthor: {}", author);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("author", author);

		return "edit-author";
	}
}
