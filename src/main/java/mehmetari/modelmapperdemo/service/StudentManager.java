package mehmetari.modelmapperdemo.service;

import mehmetari.modelmapperdemo.dto.GetAllStudentsDto;
import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;
import mehmetari.modelmapperdemo.repository.StudentRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentManager implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentManager(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        student.setCreatedBy("Müdür");
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public List<GetAllStudentsDto> getAll() {
        List<Student> studentList = studentRepository.findAll();
        List<GetAllStudentsDto> getAllStudentsDtoList = studentList.stream()
                .map(student -> modelMapper.map(student, GetAllStudentsDto.class))
                .collect(Collectors.toList());
        return getAllStudentsDtoList;
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }


}
