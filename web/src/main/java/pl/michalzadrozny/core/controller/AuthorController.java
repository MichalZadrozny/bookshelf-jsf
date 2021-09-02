package pl.michalzadrozny.core.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

@Named
@RequestScoped
public class AuthorController implements Serializable {

	private static final long serialVersionUID = 994585156676448103L;
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	@Inject
	private AuthorService authorService;

	public String addAuthor(Author author) {

		log.info("addAuthor: {}", author);

		authorService.addAuthor(author);

		return "index?faces-redirect=true";
	}

	public String updateAuthor(Author author) {

		log.info("updateAuthor: {}", author);

		authorService.updateAuthor(author);

		return "index?faces-redirect=true";
	}
}
