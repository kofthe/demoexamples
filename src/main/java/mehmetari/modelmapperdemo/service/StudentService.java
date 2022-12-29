package mehmetari.modelmapperdemo.service;

import mehmetari.modelmapperdemo.dto.GetAllStudentsDto;
import mehmetari.modelmapperdemo.dto.StudentDto;
import mehmetari.modelmapperdemo.entity.Student;

import java.util.List;

public interface StudentService {

    StudentDto add(StudentDto studentDto);

    List<GetAllStudentsDto> getAll();

    StudentDto findById(Long id);

}
