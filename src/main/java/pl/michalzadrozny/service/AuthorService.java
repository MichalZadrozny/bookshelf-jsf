package pl.michalzadrozny.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.entity.Author;

@ManagedBean
@SessionScoped
public class AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);
	public List<Author> authors = new ArrayList<>();

	public AuthorService() {
		Author author = new Author();
		author.setId(1L);
		author.setName("Name");
		author.setSurname("Surname");
		authors.add(author);
	}

	public List<Author> getAuthors() {
		log.info("Request to getAuthors");

		return authors;
	}

	public void addAuthor(Author author) {
		log.info("Request to addAuthor : {}", author);

		authors.add(author);
	}

	public Author find(Long id) {
		log.info("ID: {}", id);
		return authors.get(id.intValue() - 1);
	}
}
