package pl.michalzadrozny.web.bean;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

@Component
public class AuthorBean extends BaseBean {

	private static final long serialVersionUID = -3287379115901769109L;
	private static final Logger log = LoggerFactory.getLogger(AuthorBean.class);

	private Author author;
	private AuthorService authorService;

	@Autowired
	public AuthorBean(AuthorService authorService) {
		this.authorService = authorService;
	}

	public void init() {
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idParam != null) {
			author = authorService.getSingleAuthor(Long.parseLong(idParam));
		} else {
			author = new Author();
		}
	}

	public String addAuthor(Author author) {

		log.info("addAuthor: {}", author);

		authorService.addAuthor(author);

		return redirect("index");
	}

	public String updateAuthor(Author author) {

		log.info("updateAuthor: {}", author);

		authorService.updateAuthor(author);

		return redirect("index");
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
