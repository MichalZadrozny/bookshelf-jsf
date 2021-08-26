package pl.michalzadrozny.core.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.AuthorRepo;

@Named
@SessionScoped
public class AuthorService extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = -5829561476832144071L;
	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepo authorRepo;

	public List<Author> getAuthors() {
		log.info("Request to getAuthors");

		log.info("List of authors: {}", Arrays.toString(authorRepo.findAll().toArray()));

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
