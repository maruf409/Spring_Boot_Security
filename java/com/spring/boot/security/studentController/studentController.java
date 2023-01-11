package com.spring.boot.security.studentController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.security.studentModel.studentModel;

@RestController
@RequestMapping("api/v1/student")
@SuppressWarnings("unused")
public class studentController {

	private static List<studentModel> STUDENTS = Arrays.asList(new studentModel(12, "John", 10061),
			new studentModel(13, "Smith", 10043), new studentModel(14, "Richard", 10045),
			new studentModel(15, "Robart", 10087));

	@GetMapping("/{stuId}")
	public studentModel getStudent(@PathVariable("stuId") Integer stuId) {
		return STUDENTS.get(stuId);
	}

}
