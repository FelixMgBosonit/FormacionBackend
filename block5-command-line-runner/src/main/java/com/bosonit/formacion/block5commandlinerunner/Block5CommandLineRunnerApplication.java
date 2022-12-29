package com.bosonit.formacion.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola soy la tercera clase, esta vez desde dentro");

	}
}
