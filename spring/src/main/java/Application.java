import com.example.spring.aspectj.DemoAnotationService;
import com.example.spring.aspectj.DemoMethodService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan({"com.example.spring.*"})
public class Application {

	public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Application.class, args);
	}



}
