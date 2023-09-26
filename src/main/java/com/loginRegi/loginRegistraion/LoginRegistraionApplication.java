package com.loginRegi.loginRegistraion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
// exclude = SecurityAutoConfiguration.class

public class LoginRegistraionApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginRegistraionApplication.class, args);
	}

}
