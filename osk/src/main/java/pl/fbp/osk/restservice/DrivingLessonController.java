package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fbp.osk.entity.*;
import pl.fbp.osk.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    @GetMapping(value = "/instructor/{instructorId}/get_driving_lessons")
    public ResponseEntity<List<DrivingLesson>> getDrivingLessonByInstructor(@PathVariable Long instructorId) {
        Optional<Instructor> getinstructor = instructorService.findById(instructorId);
        if(getinstructor.isPresent()) {
            Instructor instructor = getinstructor.get();
            return ResponseEntity.ok(drivingLessonService.findByInstructor(instructor));
        }
        else {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
    @GetMapping(value = "/participant/{participantId}/get_driving_lessons")
    public ResponseEntity<List<DrivingLesson>> getDrivingLessonByParticipant(@PathVariable Long participantId) {
        Optional<Participant> getparticipant = participantService.findById(participantId);
        if(getparticipant.isPresent()) {
            Participant participant = getparticipant.get();
            return ResponseEntity.ok(drivingLessonService.findByParticipant(participant));
        }
        else {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
    @GetMapping(value = "/participant/{participantId}/get_driving_lesson_sum_hour")
    public ResponseEntity<String> getSumHourDrivingLessonByParticipant(@PathVariable Long participantId) {
        Optional<Participant> getparticipant = participantService.findById(participantId);
        if(getparticipant.isPresent()) {
            Participant participant = getparticipant.get();
            List<DrivingLesson> dlp = drivingLessonService.findByParticipant(participant);
            Integer sumHour = 0;
            for(DrivingLesson dl : dlp) {
                sumHour += dl.getSumHour();
            }
            return ResponseEntity.ok("Ustalono/odbyto " + sumHour + " godzin jazd");
        }
        else {
            return ResponseEntity.ok("Brak takiego kursanta");
        }
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

    @PatchMapping("/instructor/update/{drivingLessonId}")
    public ResponseEntity<DrivingLesson> updateDrivingLesson(@RequestBody Map<String, Object> updates,
                                                             @PathVariable Long drivingLessonId) {
        Optional<DrivingLesson> updatedDrivingLesson = drivingLessonService.updateDrivingLesson(updates, drivingLessonId);
        return ResponseEntity.of(updatedDrivingLesson);
    }

    @DeleteMapping("/instructor/delete/{drivingLessonId}")
    public void deleteDrivingLesson(@PathVariable long drivingLessonId) {
        drivingLessonService.deleteById(drivingLessonId);
    }
}
