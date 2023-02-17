package spring.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.Model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("spring/security")
public class studentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList
            (new Student(1, "John"),
                    new Student(2, "smith"),
                    new Student(3, "cherry"),
                    new Student(4, "wow"));

    @GetMapping(path = "{studentId}")
    public Student student(@PathVariable("studentId") Integer Id) {
        return STUDENT_LIST.stream().filter(student ->
                Id.equals(student.getStudentId())).findFirst().orElseThrow(() ->
                new IllegalStateException("this" + Id + "does not exit"));
    }

}
