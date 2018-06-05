package ch.so.agi.agdi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "ch.so.agi.agdi.admin", "ch.so.agi.agdi.datasource" })
public class AgdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgdiApplication.class, args);
	}
}
