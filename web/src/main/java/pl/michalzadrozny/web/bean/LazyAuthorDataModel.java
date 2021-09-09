package pl.michalzadrozny.web.bean;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

public class LazyAuthorDataModel extends LazyDataModel<Author> {

	private static final long serialVersionUID = -2200029249569271501L;
	private final AuthorService authorService;

	public LazyAuthorDataModel(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Override
	public List<Author> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filters) {
		List<Author> list = authorService.getAuthorsPagination(first, pageSize);

		this.setRowCount((int) authorService.countAuthors());

		return list;
	}
}
