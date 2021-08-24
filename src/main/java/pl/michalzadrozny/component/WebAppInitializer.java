package pl.michalzadrozny.component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sun.faces.config.FacesInitializer;

import pl.michalzadrozny.config.WebConfig;

public class WebAppInitializer extends FacesInitializer implements WebApplicationInitializer {

	private static final Logger log = LoggerFactory.getLogger(WebAppInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("onStartup");

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));

/*
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);

		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
		*/
	}

}
