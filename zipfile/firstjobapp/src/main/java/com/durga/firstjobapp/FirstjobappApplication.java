package com.durga.firstjobapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class FirstjobappApplication {

	public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println(java.util.TimeZone.getDefault());
        SpringApplication.run(FirstjobappApplication.class, args);
	}

}
