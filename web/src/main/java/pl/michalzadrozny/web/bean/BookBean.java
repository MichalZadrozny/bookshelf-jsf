package pl.michalzadrozny.web.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

@Named
public class BookBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 6060428793198404158L;

	@Autowired
	private BookService bookService;

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void init() {
		String idParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idParam != null) {
			book = bookService.getSingleBook(Long.parseLong(idParam));
		}
	}
}
