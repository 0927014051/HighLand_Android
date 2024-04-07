package com.javaweb;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}
	@GetMapping("/message")
	public String messgae() {
		return "deploy success with azure ";
	}
	
	@GetMapping("/ip")
	public String get() throws UnknownHostException {
		
		InetAddress IP=InetAddress.getLocalHost();
		
		return IP.toString();
	}
	
}
