package pl.michalzadrozny.core.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.BookRepo;

@Named
@SessionScoped
public class BookService extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = -1443938721621119046L;
	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepo bookRepo;

	@Transactional(readOnly = true)
	public List<Book> getBooks() {
		log.info("Request to getBooks");

		return bookRepo.findAll();
	}

	@Transactional
	public void addBook(Book book) {
		log.info("Request to addBook : {}", book);

		bookRepo.save(book);
	}

	@Transactional(readOnly = true)
	public Book getSingleBook(Long id) {
		log.info("Request to getSingleBook : {}", id);

		return bookRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Book with id " + id + " could not be found"));
	}

	@Transactional
	public void deleteBook(Book book) {
		log.info("Request to deleteBook : {}", book);

		bookRepo.delete(book);
	}
}
