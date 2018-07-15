package my.vaadin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import my.vaadin.backend.WatchRepository;
import my.vaadin.backend.data.entity.Watch;
import my.vaadin.ui.VaadinUI;


/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackageClasses = { VaadinUI.class, App.class })
@EnableJpaRepositories(basePackageClasses = { WatchRepository.class })
@EntityScan(basePackageClasses = { Watch.class })
public class App extends SpringBootServletInitializer
{
	public static final String APP_URL = "/";

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    
}
