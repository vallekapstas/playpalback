package ee.valiit.playpalback;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PlaypalbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaypalbackApplication.class, args);
	}

}
