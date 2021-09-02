package pl.michalzadrozny.web.bean;

import java.io.Serializable;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = 2248137359977040550L;

	public String redirect(String page) {
		return page + "?faces-redirect=true";
	}

	public String redirectWithId(String page, Long id) {
		return page + "?faces-redirect=true&id=" + id;
	}
}
