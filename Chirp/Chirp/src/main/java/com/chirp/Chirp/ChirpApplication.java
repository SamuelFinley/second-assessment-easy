package com.chirp.Chirp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChirpApplication {

	private static final Logger log = LoggerFactory.getLogger(ChirpApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ChirpApplication.class, args);
	}
}
