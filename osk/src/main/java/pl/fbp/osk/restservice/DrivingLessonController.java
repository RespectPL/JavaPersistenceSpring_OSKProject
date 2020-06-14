package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.*;
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

    @PostMapping("/instructor/determine/{instructorId}/{participantId}/{courseId}/{vehicleId}")
    public DrivingLesson newDrivingLesson(@PathVariable(value = "instructorId") Long instructorId,
                                          @PathVariable(value = "participantId") Long participantId,
                                          @PathVariable(value = "courseId") Long courseId,
                                          @PathVariable(value = "vehicleId") Long vehicleId,
                                          @RequestBody DrivingLesson drivingLesson) {
        Optional<Instructor> instructor = instructorService.findById(instructorId);
        drivingLesson.setInstructor(instructor.get());
        Optional<Participant> participant = participantService.findById(participantId);
        drivingLesson.setParticipant(participant.get());
        Optional<Course> course = courseService.findById(courseId);
        drivingLesson.setCourse(course.get());
        Optional<Vehicle> vehicle = vehicleService.findById(vehicleId);
        drivingLesson.setVehicle(vehicle.get());
        return drivingLessonService.createDrivingLesson(drivingLesson);
    }
}
