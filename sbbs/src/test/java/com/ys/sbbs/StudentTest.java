package com.ys.sbbs;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ys.sbbs.entity.Student;

@SpringBootApplication
public class StudentTest {

	public static void main(String[] args) {
		Student st = new Student();
		st.setName("kim");
		st.setSid(0);
		st.setRegDate(LocalDate.now());
		System.out.println(st.toString());
	}

}
