package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.CourseData;
import pl.fbp.osk.service.CourseDataService;
import pl.fbp.osk.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/course_data")
public class CourseDataController {
    @Autowired
    private CourseDataService courseDataService;
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<CourseData>> getAllCourseData() {
        return ResponseEntity.ok(courseDataService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CourseData> getCourseDataById(@PathVariable Long id) {
        Optional<CourseData> courseData = courseDataService.findById(id);
        return ResponseEntity.ok(courseData.get());
    }
}
