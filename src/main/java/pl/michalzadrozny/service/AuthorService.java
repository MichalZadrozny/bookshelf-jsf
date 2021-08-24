package pl.michalzadrozny.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.entity.Author;
import pl.michalzadrozny.exception.NotFoundException;
import pl.michalzadrozny.repository.AuthorRepo;

@ManagedBean
@SessionScoped
public class AuthorService extends SpringBeanAutowiringSupport {

	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepo authorRepo;

	public List<Author> getAuthors() {
		log.info("Request to getAuthors");

		return authorRepo.findAll();
	}

	public void addAuthor(Author author) {
		log.info("Request to addAuthor : {}", author);

		authorRepo.save(author);
	}

	public Author find(Long id) {
		log.info("ID: {}", id);
		return authorRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " could not be found"));
	}
}
