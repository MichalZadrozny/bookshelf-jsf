package pl.michalzadrozny.web.bean;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.michalzadrozny.core.entity.Book;
import pl.michalzadrozny.core.service.BookService;

public class LazyBookDataModel extends LazyDataModel<Book> {

	private static final long serialVersionUID = -2200029249569271501L;
	private static final Logger log = LoggerFactory.getLogger(LazyBookDataModel.class);

	private final BookService bookService;

	public LazyBookDataModel(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public List<Book> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filters) {
		log.info("Request to load : {}, {}", first, pageSize);

		List<Book> list = bookService.getBooksPagination(first, pageSize, sortBy.get("title"));
		this.setRowCount((int) bookService.countBooks());

		return list;
	}

}
