package pl.michalzadrozny.core.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.AuthorRepo;

@Named
@RequestScoped
public class AuthorService extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = -5829561476832144071L;
	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepo authorRepo;

	@Transactional(readOnly = true)
	public List<Author> getAuthors() {
		log.info("Request to getAuthors");

		return authorRepo.findAll();
	}

	@Transactional
	public void addAuthor(Author author) {
		log.info("Request to addAuthor : {}", author);

		authorRepo.save(author);
	}

	@Transactional(readOnly = true)
	public Author getSingleAuthor(Long id) {
		log.info("Request to getSingleAuthor : {}", id);
		return authorRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " could not be found"));
	}

	@Transactional
	public void deleteAuthor(Author author) {
		log.info("Request to deleteAuthor : {}", author);

		authorRepo.delete(author);
	}

	@Transactional
	public Author updateAuthor(Author newAuthor) {
		log.info("Request to updateAuthor : {}", newAuthor);

		Author authorToUpdate = authorRepo.findById(newAuthor.getId())
				.orElseThrow(() -> new NotFoundException("User with id " + newAuthor.getId() + " could not be found"));

		authorToUpdate.setName(newAuthor.getName());
		authorToUpdate.setSurname(newAuthor.getSurname());
		authorRepo.save(authorToUpdate);

		return authorToUpdate;
	}
}
