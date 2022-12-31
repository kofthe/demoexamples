package mehmetari.modelmapperdemo.controller;


import jakarta.validation.Valid;
import mehmetari.modelmapperdemo.dto.CreateSchoolRequest;
import mehmetari.modelmapperdemo.entity.School;
import mehmetari.modelmapperdemo.service.SchoolService;
import mehmetari.modelmapperdemo.utils.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping("/addschool")
    public ResponseEntity<School> add(@RequestBody @Valid CreateSchoolRequest createSchoolRequest) {
        return new ResponseEntity<>(service.add(createSchoolRequest), HttpStatus.OK);
    }


    //This method not using spring boot functionality. --> Which Object doesn't know.
    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable int id) {
        try{
            return new ResponseEntity<>(service.getSchoolById(id), HttpStatus.OK);
        }catch (Exception e){
            ApiError error = new ApiError(404, "School Not Found", "/  " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

    }


}
