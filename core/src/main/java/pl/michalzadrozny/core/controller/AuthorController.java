package pl.michalzadrozny.core.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.core.entity.Author;

@Named
@SessionScoped
public class AuthorController implements Serializable {

	private static final long serialVersionUID = 994585156676448103L;
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	public String showAuthor(Author author) {

		log.info("showAuthor: {}", author);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("showAuthor", author);

		return "author";
	}
}
