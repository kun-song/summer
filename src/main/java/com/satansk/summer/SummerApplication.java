package com.satansk.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SummerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
	}
}
