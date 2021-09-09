package pl.michalzadrozny.web.bean;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

public class LazyBookDataModel extends LazyDataModel<Book> {

	private static final long serialVersionUID = -2200029249569271501L;
	private final BookService bookService;

	public LazyBookDataModel(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public List<Book> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filters) {
		List<Book> list = bookService.getBooksPagination(first, pageSize);

		this.setRowCount((int) bookService.countBooks());

		return list;
	}

}
