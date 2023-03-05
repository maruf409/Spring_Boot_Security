package Spring.Security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spring.Security.model.student;

@CrossOrigin
@RestController
@RequestMapping(path = "/student/info")
@SuppressWarnings("all")
public class stuControler {

	private static final List<student> STUDENTS = Arrays.asList(new student(1, "studentx", "Bangla"),
			new student(2, "studenty", "English"), new student(3, "studentz", "Math"),
			new student(4, "studentw", "Biology"));

	@GetMapping(path = "/all/list")
	public List<student> allStudent() {
		return STUDENTS;
	}

	@GetMapping(path = "{id}")
	public String findStudnet(@PathVariable(value = "id") Integer id) {
		return STUDENTS.get(id).getStuName();
	}

	@DeleteMapping(path = "{id}")
	public void deleteStudent(@PathVariable(value = "id") Integer id) {
		STUDENTS.get(id).getStuName();
		STUDENTS.get(id).getDept();
	}

	@PostMapping(path = "/newrow")
	public void insertStu(@RequestBody student student) {
		System.out.println(student);
	}
}
