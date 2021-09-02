package pl.michalzadrozny.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.exception.NotFoundException;
import pl.michalzadrozny.core.repository.BookRepo;

@Service
public class BookService {

	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	private BookRepo bookRepo;

	@Autowired
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

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

	@Transactional
	public Book updateBook(Book newBook) {
		log.info("Request to updateBook : {}", newBook);

		Book bookToUpdate = bookRepo.findById(newBook.getId())
				.orElseThrow(() -> new NotFoundException("Book with id " + newBook.getId() + " could not be found"));

		bookToUpdate.setTitle(newBook.getTitle());
		bookToUpdate.setAuthor(newBook.getAuthor());
		bookRepo.save(bookToUpdate);

		return newBook;
	}
}
