package pl.michalzadrozny.core.controller;

import java.io.IOException;
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

	public void showAuthor(Author author) {

		log.info("showAuthor: {}", author);

		String url = "author.xhtml?id=" + author.getId();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}

	public void getAuthor(Long id) {

		log.info("getAuthor: {}", id);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("author", authorService.getSingleAuthor(id));
	}

	public String addAuthor(Author author) {

		log.info("addAuthor: {}", author);

		authorService.addAuthor(author);

		return "index?faces-redirect=true";
	}

	public String deleteAuthor(Author author) {

		log.info("deleteAuthor: {}", author);

		authorService.deleteAuthor(author);

		return "index?faces-redirect=true";
	}

	public String updateAuthor(Author author) {

		log.info("updateAuthor: {}", author);

		authorService.updateAuthor(author);

		return "index?faces-redirect=true";
	}

	public void showUpdateAuthor(Author author) {

		log.info("showUpdateAuthor: {}", author);

		String url = "edit-author.xhtml?id=" + author.getId();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}
}
