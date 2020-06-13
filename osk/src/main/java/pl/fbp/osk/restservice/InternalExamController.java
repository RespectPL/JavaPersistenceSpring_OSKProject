package pl.fbp.osk.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fbp.osk.entity.InternalExam;
import pl.fbp.osk.service.CourseService;
import pl.fbp.osk.service.InstructorService;
import pl.fbp.osk.service.InternalExamService;
import pl.fbp.osk.service.ParticipantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osk/internal_exams")
public class InternalExamController {
    @Autowired
    private InternalExamService internalExamService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<InternalExam>> getAllInternalExams() {
        return ResponseEntity.ok(internalExamService.findAll());
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<InternalExam> getInternalExamById(@PathVariable Long id) {
        Optional<InternalExam> internalExam = internalExamService.findById(id);
        return ResponseEntity.ok(internalExam.get());
    }
}
