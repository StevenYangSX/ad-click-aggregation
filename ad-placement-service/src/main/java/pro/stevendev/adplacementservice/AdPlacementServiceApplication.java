package pro.stevendev.adplacementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AdPlacementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdPlacementServiceApplication.class, args);
	}

}
