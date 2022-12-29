package mehmetari.modelmapperdemo.controller;

import mehmetari.modelmapperdemo.dto.GetAllStudentsDto;
import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;
import mehmetari.modelmapperdemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public List<GetAllStudentsDto> getAll() {
        return studentService.getAll();
    }
    @GetMapping("/getstudent/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

}
