package likelion10.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJpaAuditing
@PropertySource("classpath:/env.properties")
public class HelloApplication {

//	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
