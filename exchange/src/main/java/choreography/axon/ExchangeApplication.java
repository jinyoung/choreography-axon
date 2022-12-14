package choreography.axon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ExchangeApplication {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(ExchangeApplication.class, args);
    }
}
