package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.service.CourseService;

import java.util.List;
import java.util.Map;
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

    @PostMapping("/add")
    public Course newCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Course> replaceCourse(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course> replacedCourse = courseService.replaceCourse(course, id);
        return ResponseEntity.of(replacedCourse);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        Optional<Course> updatedCourse = courseService.uodateCourse(updates, id);
        return ResponseEntity.of(updatedCourse);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable long id) {
        courseService.deleteById(id);
    }
}
