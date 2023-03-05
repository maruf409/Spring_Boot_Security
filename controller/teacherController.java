package Spring.Security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.Security.model.teacher;

@CrossOrigin
@RestController
@RequestMapping("admin/student/info")
public class teacherController {

	private static final List<teacher> TEACHER_LIST = Arrays.asList(new teacher(1, "teacherX"),
			new teacher(2, "teacherY"), new teacher(3, "teacherZ"), new teacher(4, "teacherA"),
			new teacher(5, "teacherB"));

	@GetMapping("/showAll")
	private List<teacher> getTeacherList() {
		return TEACHER_LIST;
	}

	@PostMapping("/newInsert")
	public void insertTeacher(@RequestBody teacher teacher) {
		System.out.println(teacher);
	}

	@DeleteMapping(path = "{teacherId}")
	public void deleteTeacher(@PathVariable("teacherId") Integer teacherId) {
		System.out.println(teacherId);
	}

	@PutMapping(path = "{teacherId}")
	public void updateStudent(@PathVariable("teacherId") Integer teacherId) {
		System.out.printf("%s", teacherId);
	}

}