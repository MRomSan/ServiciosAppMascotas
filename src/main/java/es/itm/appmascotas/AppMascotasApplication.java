package es.itm.appmascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"es.itm"})
@EntityScan("es.itm.model")
@EnableJpaRepositories("es.itm.dao")
public class AppMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMascotasApplication.class, args);
	}

}
