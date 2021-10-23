
package usa.ciclo3.reto3;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"usa.ciclo3.reto3.models"})
@SpringBootApplication
public class Reto3Application {
    public static void main(String[] args) {
        
        SpringApplication.run(Reto3Application.class, args);
        
    }

}


