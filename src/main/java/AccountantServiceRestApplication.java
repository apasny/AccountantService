import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"api", "entity", "mapper", "repository", "service"})
public class AccountantServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountantServiceRestApplication.class, args);
    }
}