package com.example.projetfilrougejava;

import com.example.projetfilrougejava.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjetfilrougejavaApplication extends ServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ProjetfilrougejavaApplication.class, args);
	}
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("passer"));
	}
}
