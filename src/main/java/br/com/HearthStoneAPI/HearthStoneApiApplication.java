package br.com.HearthStoneAPI;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HearthStoneApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new HearthStoneApiApplication().configure(new SpringApplicationBuilder(HearthStoneApiApplication.class))
				.run(args);
	}

}
