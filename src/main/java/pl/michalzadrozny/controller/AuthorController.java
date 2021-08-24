package pl.michalzadrozny.controller;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.entity.Author;

@ManagedBean
@SessionScoped
public class AuthorController {

	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	public String updateAuthor(Author author) {

		log.info("updateAuthor: {}", author);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("author", author);

		return "author";
	}
}
