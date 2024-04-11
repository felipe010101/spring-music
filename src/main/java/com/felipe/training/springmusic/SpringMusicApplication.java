package com.felipe.training.springmusic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMusicApplication.class, args);
	}
	@Override
	public void run(String... args) {
		new App().startMenu();
	}
}