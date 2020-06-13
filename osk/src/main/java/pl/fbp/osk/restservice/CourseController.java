package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        return ResponseEntity.ok(course.get());
    }
    @GetMapping(value = "/oznaczenie/{oznaczenie}", produces = "application/json")
    public List<Course> getCourseByOznaczenie(@PathVariable String oznaczenie) {
        return courseService.findByOznaczenie(oznaczenie);
    }
}
