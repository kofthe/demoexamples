package mehmetari.modelmapperdemo.service;


import mehmetari.modelmapperdemo.dto.CreateSchoolRequest;
import mehmetari.modelmapperdemo.entity.School;
import mehmetari.modelmapperdemo.repository.SchoolRepository;
import mehmetari.modelmapperdemo.utils.error.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class SchoolManager implements SchoolService {

    SchoolRepository schoolRepository;
    ModelMapper modelMapper;

    public SchoolManager(SchoolRepository schoolRepository, ModelMapper modelMapper) {
        this.schoolRepository = schoolRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public School add(CreateSchoolRequest createSchoolRequest) {
        School school = modelMapper.map(createSchoolRequest, School.class);
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolById(int id) {
        return schoolRepository.findById(id).orElseThrow(( ) -> new NotFoundException("school does not exists"));
    }
}
