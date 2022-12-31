package mehmetari.modelmapperdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import mehmetari.modelmapperdemo.dto.GetAllStudentsDto;
import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;
import mehmetari.modelmapperdemo.service.StudentService;
import mehmetari.modelmapperdemo.utils.error.ApiError;
import mehmetari.modelmapperdemo.utils.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    //HttpStatus code is 200. In my message it is 404. This is wrong.



}
