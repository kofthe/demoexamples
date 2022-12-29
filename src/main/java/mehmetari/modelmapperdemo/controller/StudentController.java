package mehmetari.modelmapperdemo.controller;

import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;
import mehmetari.modelmapperdemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addstudent")
    public StudentDto add(@RequestBody StudentDto studentDto) {
        return studentService.add(studentDto);
    }
}
