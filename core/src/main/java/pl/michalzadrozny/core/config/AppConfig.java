package pl.michalzadrozny.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "pl.michalzadrozny.core.repository" })
@Configuration
@ComponentScan(basePackages = "pl.michalzadrozny")
public class AppConfig {

}
