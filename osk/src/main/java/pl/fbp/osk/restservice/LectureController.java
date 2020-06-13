package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.Lecture;
import pl.fbp.osk.service.InstructorService;
import pl.fbp.osk.service.LectureService;
import pl.fbp.osk.service.ParticipantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/lectures")
public class LectureController {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private ParticipantService participantService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Lecture>> getAllLectures() {
        return ResponseEntity.ok(lectureService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long id) {
        Optional<Lecture> lecture = lectureService.findById(id);
        return ResponseEntity.ok(lecture.get());
    }
}
