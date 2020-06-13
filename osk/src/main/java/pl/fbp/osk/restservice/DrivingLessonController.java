package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.DrivingLesson;
import pl.fbp.osk.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/driving_lessons")
public class DrivingLessonController {
    @Autowired
    private DrivingLessonService drivingLessonService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<DrivingLesson>> getAllDrivingLessons() {
        return ResponseEntity.ok(drivingLessonService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DrivingLesson> getDrivingLessonById(@PathVariable Long id) {
        Optional<DrivingLesson> drivingLesson = drivingLessonService.findById(id);
        return ResponseEntity.ok(drivingLesson.get());
    }
}
