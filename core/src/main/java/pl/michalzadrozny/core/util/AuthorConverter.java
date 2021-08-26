package pl.michalzadrozny.core.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import pl.michalzadrozny.core.entity.Author;
import pl.michalzadrozny.core.service.AuthorService;

@ManagedBean
@RequestScoped
public class AuthorConverter implements Converter {

	@ManagedProperty(value = "#{authorService}")
	private AuthorService authorService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
			return null;
		}

		try {
			return authorService.find(Long.valueOf(submittedValue));
		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
			return "";
		}

		if (modelValue instanceof Author) {
			return String.valueOf(((Author) modelValue).getId());
		} else {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", modelValue)));
		}
	}

	public AuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
}
