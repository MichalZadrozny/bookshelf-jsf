package pl.michalzadrozny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "pl.michalzadrozny.repository" })
@Configuration
@ComponentScan(basePackages = "pl.michalzadrozny")
public class AppConfig {

}
