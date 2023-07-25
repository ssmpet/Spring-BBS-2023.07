package com.ys.sbbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ys.sbbs.entity.Student;

@SpringBootApplication
public class SbbsApplication {

	public static void main(String[] args) {
		Student st = new Student();

		SpringApplication.run(SbbsApplication.class, args);
	}

}
