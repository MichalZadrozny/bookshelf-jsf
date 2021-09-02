package pl.michalzadrozny.web.bean;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

@Component
public class BookBean extends BaseBean {

	private static final long serialVersionUID = 6060428793198404158L;
	private static final Logger log = LoggerFactory.getLogger(BookBean.class);

	@Autowired
	private BookService bookService;

	private Book book;

	public void init() {
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idParam != null) {
			book = bookService.getSingleBook(Long.parseLong(idParam));
		} else {
			book = new Book();
		}
	}

	public String addBook(Book book) {

		log.info("addBook: {}", book);

		bookService.addBook(book);

		return redirect("index");
	}

	public String updateBook(Book book) {

		log.info("updateBook: {}", book);

		bookService.updateBook(book);

		return redirect("index");
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
