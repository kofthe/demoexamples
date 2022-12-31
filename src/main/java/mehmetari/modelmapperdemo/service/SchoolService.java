package mehmetari.modelmapperdemo.service;

import mehmetari.modelmapperdemo.dto.CreateSchoolRequest;
import mehmetari.modelmapperdemo.entity.School;

public interface SchoolService {

    School add(CreateSchoolRequest createSchoolRequest);

    School getSchoolById(int id);


}
