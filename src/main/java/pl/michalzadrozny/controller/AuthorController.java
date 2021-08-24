package pl.michalzadrozny.controller;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pl.michalzadrozny.entity.Author;

@ManagedBean
@SessionScoped
public class AuthorController extends SpringBeanAutowiringSupport {

	@Autowired
	private Properties dataSource;

	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	public String updateAuthor(Author author) {

		log.info("Datasource is null: {}", Objects.isNull(dataSource));
		log.info("Datasource: {}", dataSource);
		log.info("Datasource: {}", dataSource.get("hibernate.hbm2ddl.auto"));

		log.info("updateAuthor: {}", author);

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("author", author);

		return "author";
	}
}
