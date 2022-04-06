package isi.tn.wordcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="isi.tn.wordcup")
@SpringBootApplication
public class WordcupApplication {
	public static void main(String[] args) {
		SpringApplication.run(WordcupApplication.class, args);
	}

}
