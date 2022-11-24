import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication
@OpenAPIDefinition
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
