import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.springmvc.sse")
public class SpringmvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringmvcApplication.class, args);
	}



}
