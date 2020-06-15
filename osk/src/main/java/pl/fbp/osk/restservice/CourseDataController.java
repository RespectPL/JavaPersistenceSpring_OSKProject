package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.Course;
import pl.fbp.osk.entity.CourseData;
import pl.fbp.osk.entity.Participant;
import pl.fbp.osk.service.CourseDataService;
import pl.fbp.osk.service.CourseService;
import pl.fbp.osk.service.ParticipantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/course_data")
public class CourseDataController {
    @Autowired
    private CourseDataService courseDataService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ParticipantService participantService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<CourseData>> getAllCourseData() {
        return ResponseEntity.ok(courseDataService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CourseData> getCourseDataById(@PathVariable Long id) {
        Optional<CourseData> courseData = courseDataService.findById(id);
        return ResponseEntity.ok(courseData.get());
    }
    @GetMapping(value = "/instructor/get_participants_by_course/{oznaczenie}")
    public ResponseEntity<List<CourseData>> getCourseDataByCourse(@PathVariable String oznaczenie) {
        Optional<Course> getcourse = courseService.findByOznaczenie(oznaczenie);
        if(getcourse.isPresent()) {
            Course course = getcourse.get();
            return ResponseEntity.ok(courseDataService.findByCourse(course));
        }
        else {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
    @GetMapping(value = "instructor/get_payments/{paid}")
    public ResponseEntity<List<CourseData>> getCourseDataByPayments(@PathVariable String paid) {
        return ResponseEntity.ok(courseDataService.findByPaid(paid));
    }

    @PostMapping("/participant/{participant}/join_course/{oznaczenie}")
    public CourseData newCourseData(@PathVariable(value = "participant") Long participantId,
                                    @PathVariable(value = "oznaczenie") String oznaczenieKursu,
                                    @RequestBody CourseData courseData) {
        Optional<Participant> participant = participantService.findById(participantId);
        courseData.setParticipant(participant.get());
        Optional<Course> course = courseService.findByOznaczenie(oznaczenieKursu);
        courseData.setCourse(course.get());
        courseData.setCompleted(false);
        courseData.setPaid(false);
        return courseDataService.createCourseData(courseData);
    }
}
