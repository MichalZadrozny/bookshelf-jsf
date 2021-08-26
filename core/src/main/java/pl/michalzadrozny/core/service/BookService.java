package pl.michalzadrozny.core.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.BookRepo;

@ManagedBean
@SessionScoped
public class BookService extends SpringBeanAutowiringSupport {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepo bookRepo;

	public List<Book> getBooks() {
		log.info("Request to getBooks");

		return bookRepo.findAll();
	}

	public void addBook(Book book) {
		log.info("Request to addBook : {}", book);

		bookRepo.save(book);
	}

	public Book getSingleBook(Long id) {
		log.info("Request to getSingleBook : {}", id);

		return bookRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Book with id " + id + " could not be found"));
	}
}
