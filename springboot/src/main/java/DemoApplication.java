import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
@ComponentScan("com.example.*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication =new SpringApplication(DemoApplication.class);

		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}
}
