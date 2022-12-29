package mehmetari.modelmapperdemo.service;

import mehmetari.modelmapperdemo.dto.GetAllStudentsDto;
import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;
import mehmetari.modelmapperdemo.repository.StudentRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }


}
