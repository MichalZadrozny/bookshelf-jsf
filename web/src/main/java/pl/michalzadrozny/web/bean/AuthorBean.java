package pl.michalzadrozny.web.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

@Named
public class AuthorBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = -3287379115901769109L;

	@Autowired
	private AuthorService authorService;

	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void init() {
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idParam != null) {
			author = authorService.getSingleAuthor(Long.parseLong(idParam));
		} else {
			author = new Author();
		}
	}
}
