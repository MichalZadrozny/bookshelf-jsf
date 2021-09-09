package pl.michalzadrozny.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.AuthorRepo;

@Service
public class AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	private AuthorRepo authorRepo;

	@Autowired
	public AuthorService(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}

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

	@Transactional(readOnly = true)
	public List<Author> getAuthorsPagination(int first, int pageSize) {
		log.info("Request to getAuthorsPagination");

		return authorRepo.findAll(PageRequest.of(first, pageSize)).getContent();
	}

	@Transactional(readOnly = true)
	public long countAuthors() {
		log.info("Request to countAuthors");

		return authorRepo.count();
	}
}
