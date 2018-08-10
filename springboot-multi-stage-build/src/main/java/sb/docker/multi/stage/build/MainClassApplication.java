package sb.docker.multi.stage.build;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClassApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MainClassApplication.class, args);
	}	
}
