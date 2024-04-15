package com.insuranceapplication.demo;

import com.insuranceapplication.demo.data.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceApplicationSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(InsuranceApplicationSystemApplication.class, args);
	}
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {
	}
}
