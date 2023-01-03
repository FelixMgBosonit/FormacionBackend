package com.bosonit.formacion.block5profiles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Block5ProfilesApplication  implements CommandLineRunner {

	private final AppConfig appConfig;
	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("activeProfile: {}. bd.url: {}", appConfig.getActiveProfile(),appConfig.getBdurl() );
	}
}
