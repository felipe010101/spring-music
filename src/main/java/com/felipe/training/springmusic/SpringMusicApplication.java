package com.felipe.training.springmusic;

import com.felipe.training.springmusic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMusicApplication.class, args);
	}
	@Override
	public void run(String... args) {
		new App(repository).startMenu();
	}
}